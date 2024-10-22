package com.example.myapp

import ViewPagerAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set adapter untuk ViewPager2
        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        // Hubungkan TabLayout dengan ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Login"
                1 -> "Register"
                else -> "Tab"
            }
        }.attach()  // Gunakan TabLayoutMediator untuk menghubungkan TabLayout dengan ViewPager2
    }
}
