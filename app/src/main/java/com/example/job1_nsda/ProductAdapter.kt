package com.example.job1_nsda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(private val products: List<Products>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImage: ImageView = itemView.findViewById(R.id.imageTxt)
        private val productName: TextView = itemView.findViewById(R.id.NameTxt)
        private val productPrice: TextView = itemView.findViewById(R.id.priceTxt)
        private val productDescription: TextView =itemView.findViewById(R.id.descriptionTxt)
        private val updatedAt: TextView= itemView.findViewById(R.id.updatedAt)
        fun bind(product: Products) {
            Glide.with(itemView)
                .load(product.images[0])
                .into(productImage)
            productName.text = product.title
            productPrice.text = "$${product.price}"
            productDescription.text= product.description
            updatedAt.text = product.updatedAt
        }
    }
}