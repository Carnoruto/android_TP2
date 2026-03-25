package com.tonpackage.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tonpackage.data.NinjaRepository

class NinjaViewModelFactory(
    private val repository: NinjaRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NinjaViewModel(repository) as T
    }
}