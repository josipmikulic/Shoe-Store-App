package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeData = mutableListOf<Shoe>()
    val _name = MutableLiveData("")
    val _company = MutableLiveData("")
    val _size = MutableLiveData("")
    val _description = MutableLiveData("")

    val shoeData: List<Shoe> = _shoeData
    val name: LiveData<String> = _name
    val company: LiveData<String> = _company
    val size: LiveData<String> = _size
    val description: LiveData<String> = _description

    fun saveShoeData() {
        val newShoe = Shoe(name.value, company.value, size.value?.toInt(), description.value)
        _shoeData.add(newShoe)
    }
}