package com.udacity.shoestore.ui.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.ui.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            shoeViewModel = ViewModelProvider(it)[ShoeViewModel::class.java]
        }

        binding.apply {
            binding.viewModel = shoeViewModel
            buttonCancel.setOnClickListener {
                it.findNavController()
                    .navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
            }
            buttonSave.setOnClickListener {
                shoeViewModel.saveShoeData()
                it.findNavController()
                    .navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
            }
        }
    }

}
