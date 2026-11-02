package com.example.Noval_3tiB

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.Noval_3tiB.databinding.ItemProductBinding

class ProductAdapter(
    context: Context,
    private val productList: List<Product>
) : ArrayAdapter<Product>(context, 0, productList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemProductBinding
        val view: View

        if (convertView == null) {
            binding = ItemProductBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as ItemProductBinding
        }

        val item = productList[position]
        binding.txtProductName.text = item.name
        binding.txtProductCategory.text = item.category
        binding.txtProductPrice.text = item.price
        binding.imgProduct.setImageResource(item.imageResId)

        return view
    }
}