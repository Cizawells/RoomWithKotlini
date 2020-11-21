package com.wells.asystapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wells.asystapp.R
import com.wells.asystapp.data.ProductViewModal
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {
private lateinit var productViewModal:ProductViewModal

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_list, container, false)

        //recyclervuew
        val adapter = ListAdapter()
        val recyclerview = view.recyclerview
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        //viewmodel
        productViewModal = ViewModelProvider(this).get(ProductViewModal::class.java)
        productViewModal.readAllData.observe(viewLifecycleOwner, { product ->
            adapter.setData(product)
        })

            view.floatingActionButton.setOnClickListener {
                findNavController().navigate(R.id.action_listFragment_to_addFragment)
            }
        return view
    }


}