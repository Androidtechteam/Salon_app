package com.lnd.salon.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.lnd.salon.R
import com.lnd.salon.adapter.SaloonDetailsAdapter
import com.lnd.salon.databinding.FragmentSalonDetailsBinding
import com.lnd.salon.presentation.common.CommonUtils
import com.lnd.salon.presentation.common.StatusCalled
import com.lnd.salon.presentation.viewmodel.CommonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import org.json.JSONObject

@AndroidEntryPoint
class SalonDetailsFragment : Fragment() {

    private val viewModel: CommonViewModel by viewModels()
    lateinit var binding: FragmentSalonDetailsBinding
    lateinit var saloonDetailsAdapter: SaloonDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSalonDetailsBinding.inflate(layoutInflater)
        saloonDetailsAdapter = SaloonDetailsAdapter(requireContext(),object : SaloonDetailsAdapter.ItemClickListener{
            override fun onItemClick(view: View?, position: Int) {

            }

        })
        binding.rvSpecialists.adapter = saloonDetailsAdapter
        binding.rvSpecialists.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)


        binding.inHeader.imToolbarBack.setOnClickListener {

        }
        binding.inHeader.tvToolbarText.text = "Saloon Details"
        if (arguments != null) {
            arguments?.getString("saloonId","0")?.let { viewModel.saloonSummary("-100") }
            observeSaloonDetails()
        }
        return binding.root
    }

    private fun observeSaloonDetails() {
        try {
            lifecycleScope.launch {
                viewModel.saloonDetailsResponse.catch {

                }.flowWithLifecycle(lifecycle, Lifecycle.State.CREATED)
                    .collect {
                        when (it.status) {
                            StatusCalled.SUCCESS -> {
                                it.data?.let { it1 -> saloonDetailsAdapter.setData(it1.data.emlpoyees)}
                            }
                            StatusCalled.ERROR -> {
                                val json = JSONObject(it.message ?: "")
                                CommonUtils.toast(requireContext(), json.getString("error"))
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


}