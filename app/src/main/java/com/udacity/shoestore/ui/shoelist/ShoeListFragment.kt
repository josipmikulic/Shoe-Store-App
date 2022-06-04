package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.ui.ShoeViewModel
import kotlinx.android.synthetic.main.item_shoe.view.*

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            shoeViewModel = ViewModelProvider(it)[ShoeViewModel::class.java]
        }
        binding.fab.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetail)
        }
    }

    override fun onResume() {
        super.onResume()
        shoeViewModel.shoeData.forEach {
            val newShoe = layoutInflater.inflate(R.layout.item_shoe, binding.linearLayout, false)
            newShoe.shoe_name.text = it.name
            newShoe.shoe_company.text = it.company
            newShoe.shoe_size.text = it.size.toString()
            newShoe.shoe_description.text = it.description

            binding.linearLayout.addView(newShoe)
        }
    }

}