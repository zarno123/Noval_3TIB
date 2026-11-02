package com.example.Noval_3tiB

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.Noval_3tiB.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sharedPref = getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)


        Handler(Looper.getMainLooper()).postDelayed({
            if (isLogin) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 2000)
    }
}