package com.wells.asystapp.fragments.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wells.asystapp.R
import com.wells.asystapp.data.Product
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var productList = emptyList<Product>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = productList[position]
        holder.itemView.id =currentItem.id
        holder.itemView.name.text = currentItem.name
        holder.itemView.price.text = currentItem.price.toString()
    }

    override fun getItemCount(): Int {

        return productList.size
    }

    fun setData(product: List<Product>) {
this.productList = product
        print(productList)
        notifyDataSetChanged()
    }
}