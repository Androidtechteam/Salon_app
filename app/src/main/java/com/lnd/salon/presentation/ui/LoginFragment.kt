package com.lnd.salon.presentation.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.lnd.salon.databinding.FragmentLoginBinding
import com.lnd.salon.presentation.common.CommonUtils
import com.lnd.salon.presentation.common.SharedPref
import com.lnd.salon.presentation.common.StatusCalled
import com.lnd.salon.presentation.models.LoginResponseModel
import com.lnd.salon.presentation.viewmodel.CommonViewModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject
import java.nio.charset.StandardCharsets

@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    private val viewModel: CommonViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.btSignIn.setOnClickListener {

            if (validations()) {
                val `object` = JSONObject()
                `object`.put("emailId", binding.etEmail.text.toString())
                `object`.put("password", binding.etPassword.text.toString())
                viewModel.getLoginResponse(
                    requestBody = RequestBody.create(
                        "application/json; charset=utf-8".toMediaTypeOrNull(),
                        `object`.toString()
                    )
                )
                observeLoginResponse()
            }
        }

        binding.tvSignUp.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginScreenToSignupScreen()
            Navigation.findNavController(binding.root).navigate(action)
        }
        return binding.root
    }

    private fun observeLoginResponse() {
        try {
            lifecycleScope.launch {
                viewModel.response.catch {

                }.flowWithLifecycle(lifecycle, Lifecycle.State.CREATED)
                    .collect {
                        when (it.status) {
                            StatusCalled.SUCCESS -> {
                                val convertedInputStream = String(
                                    it.data!!.source().readByteArray(),
                                    StandardCharsets.UTF_8
                                )
                                val json = JSONObject(convertedInputStream)

                                if(json.has("status")){
                                    CommonUtils.toast(requireContext(),json.getString("message"))
                                }else {
                                    val moshi = Moshi.Builder()
                                        .add(KotlinJsonAdapterFactory())
                                        .build()

                                    val jsonAdapter: JsonAdapter<LoginResponseModel> =
                                        moshi.adapter(LoginResponseModel::class.java)

                                    val loginResponseModel: LoginResponseModel? =
                                        jsonAdapter.fromJson(convertedInputStream)

                                    SharedPref.setApiToken(
                                        requireContext(),
                                        loginResponseModel?.oauthToken
                                    )

                                    CommonUtils.toast(
                                        requireContext(),
                                        loginResponseModel?.oauthToken
                                    )
                                    val action =
                                        LoginFragmentDirections.actionLoginScreenToDashboardScreen()
                                    Navigation.findNavController(binding.root).navigate(action)
                                }
//
                            }
                            StatusCalled.ERROR -> {
                                val json = JSONObject(it.message?:"")


                                CommonUtils.toast(requireContext(), json.getString("message"))

                            }
                            StatusCalled.LOADING -> {

                                CommonUtils.toast(requireContext(), "Loading...")
                            }
                        }
                    }
            }
        } catch (ex: Exception) {
            ex.message
        }
    }

    private fun validations(): Boolean {
        try {
            if (TextUtils.isEmpty(binding.etEmail.text.toString())) {
                CommonUtils.toast(requireContext(), "Please enter email")
                return false
            } else if (TextUtils.isEmpty(binding.etPassword.text.toString())) {
                CommonUtils.toast(requireContext(), "Please enter password")
                return false
            }
        } catch (ex: java.lang.Exception) {
            ex.message
        }

        return true
    }


}