package com.example.myapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayout.R
import com.example.tablayout.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Button click listener for Register
        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (validateInput(name, email, password)) {
                Toast.makeText(requireContext(), "Registered successfully", Toast.LENGTH_SHORT).show()

                // Automatically switch to login fragment after registration
                switchToLoginTab()
            }
        }
    }

    // Function to switch to the Login tab in ViewPager2
    private fun switchToLoginTab() {
        // Get ViewPager2 from the parent activity
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        viewPager?.currentItem = 0 // Switch to LoginFragment (assumed to be at position 0)
    }

    // Function to validate input
    private fun validateInput(name: String, email: String, password: String): Boolean {
        return when {
            name.isEmpty() -> {
                Toast.makeText(requireContext(), "Name cannot be empty", Toast.LENGTH_SHORT).show()
                false
            }
            email.isEmpty() -> {
                Toast.makeText(requireContext(), "Email cannot be empty", Toast.LENGTH_SHORT).show()
                false
            }
            password.isEmpty() -> {
                Toast.makeText(requireContext(), "Password cannot be empty", Toast.LENGTH_SHORT).show()
                false
            }
            password.length < 6 -> {
                Toast.makeText(requireContext(), "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
