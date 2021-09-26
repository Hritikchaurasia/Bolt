package com.example.bolt.ui.splashscreen

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.greentaxi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {
    private val viewModel by viewModels<SplashScreenViewModel>()
     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.isDelayComplete.observe(viewLifecycleOwner){ delay->
            if(delay){
                if(viewModel.isLoggedIn){
                    findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
                }else{
                    findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
                }
            }
        }
    }

}