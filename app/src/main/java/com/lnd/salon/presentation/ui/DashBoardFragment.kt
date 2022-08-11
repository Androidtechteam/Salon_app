package com.lnd.salon.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.lnd.salon.adapter.CategoriesAdapter
import com.lnd.salon.databinding.FragmentDashBoardBinding
import com.lnd.salon.presentation.common.StatusCalled
import com.lnd.salon.presentation.viewmodel.CommonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashBoardFragment : Fragment() {

    lateinit var binding: FragmentDashBoardBinding
    private val viewModel: CommonViewModel by viewModels()
    lateinit var categoriesAdapter : CategoriesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDashBoardBinding.inflate(layoutInflater)
        categoriesAdapter = CategoriesAdapter(requireContext())
        binding.rvServices.adapter = categoriesAdapter
        binding.rvServices.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        getCategories()


//        val myImageNameList = arrayOf("1", "2", "3", "4", "5")
//        val servicesAdapter = ServicesAdapter(requireContext(),myImageNameList)
//        binding.rvServices.adapter = servicesAdapter
//        binding.rvServices.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
//
//
//        binding.btAppointment.setOnClickListener {
//            val action = DashBoardFragmentDirections.actionDashboardScreenToSearchSalonFragment()
//            Navigation.findNavController(binding.view).navigate(action)
//        }
        return binding.root
    }

    private fun getCategories() {
        viewModel.categories()
        observeCategoriesResponse()
    }

    private fun observeCategoriesResponse(){
        try{
            lifecycleScope.launch{
                viewModel.response.catch {

                }.flowWithLifecycle(lifecycle)
                    .collect{
                        when(it.status){
                            StatusCalled.SUCCESS ->{
//                                categoriesAdapter.setData(i)
                            }
                            StatusCalled.ERROR ->{

                            }
                            StatusCalled.LOADING ->{

                            }

                        }
                    }
            }
        }catch (ex:Exception){
            ex.message
        }
    }


}