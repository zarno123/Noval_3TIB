package com.example.Noval_3tiB

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // 1. Ambil Nama User yang Sedang Login
        val sharedPref = requireActivity().getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("savedUser", "noval") ?: "noval"
        val txtHalo = view.findViewById<TextView>(R.id.txtHaloNama)
        txtHalo.text = "$username 👋"

        // 2. Tombol Lihat Koleksi -> Membuka Tutorial Screen
        val btnKoleksi = view.findViewById<MaterialButton>(R.id.btnLihatKoleksi)
        btnKoleksi.setOnClickListener {
            startActivity(Intent(requireContext(), TutorialActivity::class.java))
        }

        // 3. Interaksi Chip Group (Kategori Kriya)
        val chipGroup = view.findViewById<ChipGroup>(R.id.chipGroupKriya)
        chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            if (checkedIds.isNotEmpty()) {
                val chip = view.findViewById<Chip>(checkedIds.first())
                Toast.makeText(requireContext(), "Kategori: ${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}