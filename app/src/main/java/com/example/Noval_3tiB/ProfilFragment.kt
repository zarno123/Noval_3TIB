package com.example.Noval_3tiB

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val sharedPref = requireActivity().getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("savedUser", "noval") ?: "noval"

        val layout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(48, 48, 48, 48)
        }

        val imgLogo = ImageView(requireContext()).apply {
            setImageResource(R.drawable.logoleatherforge)
            layoutParams = LinearLayout.LayoutParams(250, 250)
        }

        val txtUser = TextView(requireContext()).apply {
            text = "Pengrajin: $username"
            textSize = 20f
            setTextColor(Color.parseColor("#2E1C14"))
            setPadding(0, 24, 0, 32)
        }

        val btnLogout = Button(requireContext()).apply {
            text = "LogOut Akun"
            setBackgroundColor(Color.parseColor("#2E1C14"))
            setTextColor(Color.WHITE)
            setOnClickListener {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Konfirmasi LogOut")
                    .setMessage("Keluar dari akun LeatherForge?")
                    .setPositiveButton("Ya") { _, _ ->
                        sharedPref.edit().putBoolean("isLogin", false).apply()
                        Toast.makeText(requireContext(), "Berhasil Keluar Akun", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(requireActivity(), LoginActivity::class.java))
                        requireActivity().finish()
                    }
                    .setNegativeButton("Batal", null)
                    .show()
            }
        }

        layout.addView(imgLogo)
        layout.addView(txtUser)
        layout.addView(btnLogout)

        return layout
    }
}