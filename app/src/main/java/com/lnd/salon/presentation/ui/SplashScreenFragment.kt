package com.lnd.salon.presentation.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.lnd.salon.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {

    lateinit var binding: FragmentSplashScreenBinding
    private val SPLASH_DISPLAY_LENGTH = 3000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(layoutInflater)

        Handler().postDelayed({
            val action = SplashScreenFragmentDirections.actionSplashScreenToLoginScreen()
            Navigation.findNavController(binding.root).navigate(action)
        }, SPLASH_DISPLAY_LENGTH.toLong())

        return binding.root
    }


}