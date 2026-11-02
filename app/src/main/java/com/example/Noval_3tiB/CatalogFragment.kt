package com.example.Noval_3tiB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment

class CatalogFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val listView = ListView(requireContext())
        listView.divider = null

        val productList = listOf(
            Product("Bifold Wallet Classic", "Dompet Kulit", "Rp 275.000", R.drawable.dompetkulit),
            Product("Cardholder Minimalist", "Dompet Kartu", "Rp 120.000", R.drawable.dompetkartuu),
            Product("Leather Watch Strap", "Tali Jam Kulit", "Rp 185.000", R.drawable.talijam),
            Product("leather key pouch", "Tas Kunci Kulit", "Rp 320.000", R.drawable.taskunci),
            Product("Handmade Leather Belt", "Sabuk Kulit Asli", "Rp 350.000", R.drawable.sabukkulit)
        )

        listView.adapter = ProductAdapter(requireContext(), productList)

        listView.setOnItemClickListener { _, _, position, _ ->
            val item = productList[position]
            Toast.makeText(requireContext(), "${item.name} - ${item.price}", Toast.LENGTH_SHORT).show()
        }

        return listView
    }
}