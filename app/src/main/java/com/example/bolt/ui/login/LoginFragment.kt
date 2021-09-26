package com.example.bolt.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.greentaxi.R
import com.example.greentaxi.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*


@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private val viewModel by viewModels<LoginViewModel>()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
          tf_phoneNumber.editText?.text?.let {
                if(it.length >12)
                  viewModel.login(it.toString() , requireActivity())
                else
                    Toast.LENGTH_SHORT
          }

        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
          if(isLoading){
              binding.progressCircular.visibility = View.VISIBLE
              binding.tfPhoneNumber.visibility = View.GONE
              binding.tvPhoneNumber.visibility = View.GONE
              binding.btnLogin.visibility = View.GONE
              binding.imageViewLogin.visibility = View.GONE
          }
        }

        viewModel.isSuccess.observe(viewLifecycleOwner){ success ->
            if(success){
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}