package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeData = mutableListOf<Shoe>()
    private val _name = MutableLiveData("")
    private val _company = MutableLiveData("")
    private val _size = MutableLiveData(0)
    private val _description = MutableLiveData("")

    val shoeData: List<Shoe> = _shoeData
    val name: LiveData<String> = _name
    val company: LiveData<String> = _company
    val size: LiveData<Int> = _size
    val description: LiveData<String> = _description

    fun onNameChanged(name: CharSequence) {
        if (_name.value != name.toString()) {
            _name.value = name.toString()
        }
    }

    fun onCompanyChanged(company: CharSequence) {
        if (_company.value != company.toString()) {
            _company.value = company.toString()
        }
    }

    fun onSizeChanged(size: CharSequence) {
        if (_size.value != size.toString().toInt()) {
            _size.value = size.toString().toInt()
        }
    }

    fun onDescriptionChanged(description: CharSequence) {
        if (_description.value != description.toString()) {
            _description.value = description.toString()
        }
    }

    fun saveShoeData() {
        val newShoe = Shoe(name.value, company.value, size.value, description.value)
        _shoeData.add(newShoe)
    }
}