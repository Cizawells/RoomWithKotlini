package com.wells.asystapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.wells.asystapp.R
import com.wells.asystapp.data.Product
import com.wells.asystapp.data.ProductViewModal
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*



class AddFragment : Fragment() {

   private lateinit var productViewModal: ProductViewModal

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        productViewModal = ViewModelProvider(this).get(ProductViewModal::class.java)
        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }
       return view;
    }

private fun insertDataToDatabase() {
    val name = name.text.toString()
    val description = description.text.toString()
    val price = price.text.toString()
    if(inputCheck(name, description, price)) {
        val product: Product = Product(0, name, description, price.toInt())
        productViewModal.addProduct(product)
        Toast.makeText(getContext(), "successfully added", Toast.LENGTH_LONG).show()

        //navigate back to list
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }else{
        Toast.makeText(getContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
    }
}

    fun inputCheck(name:String, description:String, price:String):Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(description) && TextUtils.isEmpty(price))
    }

}