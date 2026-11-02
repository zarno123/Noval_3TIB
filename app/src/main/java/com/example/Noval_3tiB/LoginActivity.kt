package com.example.Noval_3tiB

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Noval_3tiB.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPref = getSharedPreferences("UserPref", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val user = binding.edtText.text.toString().trim()
            val pass = binding.edtPass2.text.toString().trim()


            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Username dan Password wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            if (user == "noval" && pass == "123") {

                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("savedUser", user)
                editor.apply()


                Toast.makeText(this, "Login Berhasil! Selamat Datang $user", Toast.LENGTH_LONG).show()


                val intent = Intent(this, OnboardingActivity::class.java)
                intent.putExtra("USERNAME", user)
                startActivity(intent)
                finish()
            } else {

                Toast.makeText(this, "Login Gagal! Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}