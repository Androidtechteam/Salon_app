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
import com.lnd.salon.adapter.BranchesAdapter
import com.lnd.salon.adapter.CategoriesAdapter
import com.lnd.salon.databinding.FragmentDashBoardBinding
import com.lnd.salon.presentation.common.CommonUtils
import com.lnd.salon.presentation.common.StatusCalled
import com.lnd.salon.presentation.viewmodel.CommonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import org.json.JSONObject

@AndroidEntryPoint
class DashBoardFragment : Fragment() {

    lateinit var binding: FragmentDashBoardBinding
    private val viewModel: CommonViewModel by viewModels()
    lateinit var categoriesAdapter : CategoriesAdapter
    lateinit var branchesAdapter: BranchesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDashBoardBinding.inflate(layoutInflater)
        categoriesAdapter = CategoriesAdapter(requireContext())
        branchesAdapter = BranchesAdapter(requireContext())
        binding.rvServices.adapter = categoriesAdapter
        binding.rvServices.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvNearSalon.adapter = branchesAdapter
        binding.rvNearSalon.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        binding.tvViewAll.setOnClickListener{
            val action = DashBoardFragmentDirections.actionDashboardScreenToViewAllSalonFragment()
            Navigation.findNavController(binding.root).navigate(action)
        }

        getCategories()
        getbraches()
        return binding.root
    }

    private fun getCategories() {
        viewModel.categories()
        observeCategoriesResponse()
    }

    private fun observeCategoriesResponse(){
        try{
            lifecycleScope.launch{
                viewModel.categoriesResponse.catch {

                }.flowWithLifecycle(lifecycle,Lifecycle.State.CREATED)
                    .collect{
                        when(it.status){
                            StatusCalled.SUCCESS ->{
                                it.data?.let { it1 -> categoriesAdapter.setData(it1.data) }
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

    private fun getbraches() {
        viewModel.branches("0","0")
        observebranchesResponse()
    }

    private fun observebranchesResponse(){
        try{
            lifecycleScope.launch{
                viewModel.branchesResponse.catch {

                }.flowWithLifecycle(lifecycle,Lifecycle.State.CREATED)
                    .collect{
                        when(it.status){
                            StatusCalled.SUCCESS ->{
                                it.data?.let { it1 -> branchesAdapter.setData(it1.data) }
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