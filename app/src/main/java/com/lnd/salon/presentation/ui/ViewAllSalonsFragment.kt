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
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.lnd.salon.adapter.NearSaloonAdapter
import com.lnd.salon.databinding.FragmentViewAllSalonsBinding
import com.lnd.salon.presentation.common.CommonUtils
import com.lnd.salon.presentation.common.StatusCalled
import com.lnd.salon.presentation.viewmodel.CommonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import org.json.JSONObject

@AndroidEntryPoint
class ViewAllSalonsFragment : Fragment() {

    private val viewModel: CommonViewModel by viewModels()
    lateinit var binding: FragmentViewAllSalonsBinding
    lateinit var nearSaloonAdapter:NearSaloonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewAllSalonsBinding.inflate(layoutInflater)
        binding.inHeader.tvToolbarText.text = "Near All Saloons"
        binding.inHeader.imToolbarBack.setOnClickListener {

        }
        nearSaloonAdapter = NearSaloonAdapter(requireContext(),object : NearSaloonAdapter.ItemClickListener{
            override fun onItemClick(view: View?, position: Int, saloonId: Int) {
                val action = ViewAllSalonsFragmentDirections.actionViewAllSalonFragmentToSalonDetailsFragment(saloonId.toString())
                Navigation.findNavController(binding.root).navigate(action)
            }

        })
        binding.rvViewAllSaloons.adapter = nearSaloonAdapter
        binding.rvViewAllSaloons.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)

        getNearBySaloons()
        return binding.root
    }

    private fun getNearBySaloons() {
        viewModel.nearBySaloons()
        observeNearBySaloons()
    }

    private fun observeNearBySaloons() {
        try{
            lifecycleScope.launch{
               viewModel.saloonResponse.catch {

               }.flowWithLifecycle(lifecycle,Lifecycle.State.CREATED)
                   .collect{
                       when(it.status){
                           StatusCalled.SUCCESS ->{
                               it.data?.let { it1 -> nearSaloonAdapter.setData(it1.data) }
                           }
                           StatusCalled.ERROR ->{
                               val json = JSONObject(it.message?:"")
                               CommonUtils.toast(requireContext(), json.getString("message"))
                           }
                           StatusCalled.LOADING ->{
                               CommonUtils.toast(requireContext(), "Loading...")
                           }

                       }
                   }
            }
        }catch (ex:Exception){
            ex.message
        }

    }


}