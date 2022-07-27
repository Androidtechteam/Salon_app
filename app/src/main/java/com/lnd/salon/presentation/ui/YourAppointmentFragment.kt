package com.lnd.salon.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lnd.salon.R
import com.lnd.salon.databinding.ActivityMainBinding
import com.lnd.salon.databinding.FragmentYourAppointmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YourAppointmentFragment : Fragment() {

   lateinit var binding:FragmentYourAppointmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYourAppointmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


}