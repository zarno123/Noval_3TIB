package com.example.Noval_3tiB

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.Noval_3tiB.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Halaman awal default
        if (savedInstanceState == null) {
            gantiFragment(HomeFragment())
        }

        // Navigasi Bottom Menu
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    gantiFragment(HomeFragment())
                    true
                }
                R.id.nav_catalog -> {
                    gantiFragment(CatalogFragment())
                    true
                }
                R.id.nav_profile -> {
                    gantiFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun gantiFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}