package com.example.job1_nsda

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.job1_nsda.Apiclient.apiService
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>> get() = _products

    init {
        viewModelScope.launch {
            fetchProducts()
        }
    }

    private suspend fun fetchProducts() {
        try {
            val response = apiService.getProducts()
            _products.postValue(response)
        } catch (e: Exception) {
            // Handle error
        }
    }
}