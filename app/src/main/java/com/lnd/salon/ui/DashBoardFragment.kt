package com.lnd.salon.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.lnd.salon.adapter.ServicesAdapter
import com.lnd.salon.databinding.FragmentDashBoardBinding


class DashBoardFragment : Fragment() {

    lateinit var binding: FragmentDashBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDashBoardBinding.inflate(layoutInflater)
        val myImageNameList =
            arrayOf("1", "2", "3", "4", "5")
        val servicesAdapter = ServicesAdapter(requireContext(),myImageNameList)
        binding.rvServices.adapter = servicesAdapter
        binding.rvServices.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)


        binding.btAppointment.setOnClickListener {
            val action = DashBoardFragmentDirections.actionDashboardScreenToSearchSalonFragment()
            Navigation.findNavController(binding.view).navigate(action)
        }
        return binding.root
    }


}