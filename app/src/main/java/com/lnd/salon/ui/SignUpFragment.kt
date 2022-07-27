package com.lnd.salon.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.lnd.salon.databinding.FragmentSignUpBinding
import com.lnd.salon.presentation.ui.SignUpFragmentDirections

class SignUpFragment : Fragment() {

    lateinit var binding : FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        binding.tvSignIn.setOnClickListener {
            val action = SignUpFragmentDirections.actionSignupScreenToLoginScreen()
            Navigation.findNavController(binding.view).navigate(action)
        }

        binding.btSignUp.setOnClickListener {
            val action = SignUpFragmentDirections.actionSignupScreenToDashboardScreen()
            Navigation.findNavController(binding.view).navigate(action)
        }
        return binding.root
    }

}