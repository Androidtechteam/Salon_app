package com.lnd.salon.presentation.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.lnd.salon.databinding.FragmentLoginBinding
import com.lnd.salon.presentation.common.CommonUtils
import com.lnd.salon.presentation.common.StatusCalled
import com.lnd.salon.presentation.viewmodel.CommonViewModel
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
                `object`.put("email", binding.etEmail.text.toString())
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

                }.flowWithLifecycle(lifecycle)
                    .collect {
                        when (it.status) {
                            StatusCalled.SUCCESS -> {
                                val convertedInputStream = String(
                                    it.data!!.source().readByteArray(),
                                    StandardCharsets.UTF_8
                                )
                                val json = JSONObject(convertedInputStream)
                                if(!json.getString("status").equals("error",true)) {
//                                    val jsonObject = json.getJSONObject("data")
                                    CommonUtils.toast(requireContext(),json.toString())
                                    val action = LoginFragmentDirections.actionLoginScreenToDashboardScreen()
                                    Navigation.findNavController(binding.root).navigate(action)
                                }else{
                                    CommonUtils.toast(requireContext(),json.getString("message"))
                                }
//
                            }
                            StatusCalled.ERROR -> {
                                CommonUtils.toast(requireContext(),it.message)

                            }
                            StatusCalled.LOADING -> {
                                CommonUtils.toast(requireContext(),"Loading...")
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