package com.lnd.salon.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.lnd.salon.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.btSignIn.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginScreenToDashboardScreen()
            Navigation.findNavController(binding.root).navigate(action)
        }

        binding.tvSignUp.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginScreenToSignupScreen()
            Navigation.findNavController(binding.root).navigate(action)
        }
        return binding.root
    }


}