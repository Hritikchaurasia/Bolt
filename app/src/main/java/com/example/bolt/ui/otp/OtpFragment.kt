package com.example.bolt.ui.otp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.greentaxi.R
import com.example.greentaxi.databinding.FragmentOtpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtpFragment : Fragment(R.layout.fragment_otp) {
    private val viewModel by viewModels<OtpViewModel>()
    private var _binding : FragmentOtpBinding? = null
    private val binding get() =  _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentOtpBinding.bind(view)


//
//        binding.otp.setOnClickListener {
//            val isValid : Boolean = viewModel.checkOtp("123")
//            print(isValid.toString())
//            Log.d("isValid", "isvalid : ${isValid}")
//        }
//        fun checkOtp(){
//           val isValid : Boolean = viewModel.checkOtp("123")
//            print(isValid.toString())
//            Log.d("isValid", "isvalid : ${isValid}")
//        }

    }
}