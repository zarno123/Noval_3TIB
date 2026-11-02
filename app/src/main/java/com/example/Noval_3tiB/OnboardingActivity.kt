package com.example.Noval_3tiB

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.Noval_3tiB.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data username yang diteruskan dari login
        val username = intent.getStringExtra("USERNAME") ?: "noval"

        // Klik tombol untuk lanjut ke MainActivity
        binding.btnExplore.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("USERNAME", username)
            startActivity(intent)
            finish()
        }
    }
}