package com.tonpackage.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tonpackage.data.NinjaRepository
import com.tonpackage.data.local.NinjaEntity
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NinjaViewModel(
    private val repository: NinjaRepository
) : ViewModel() {

    private val searchQuery = MutableStateFlow("")

    val ninjas: StateFlow<List<NinjaEntity>> =
        searchQuery.flatMapLatest { query ->
            if (query.isEmpty()) repository.getAll()
            else repository.search(query)
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun setSearch(query: String) {
        searchQuery.value = query
    }

    fun addDefaultNinjas() {
        viewModelScope.launch {

            val ninjas = listOf(
                NinjaEntity(name = "Naruto", village = "Konoha", chakra = 90),
                NinjaEntity(name = "Sasuke", village = "Konoha", chakra = 95),
                NinjaEntity(name = "Sakura", village = "Konoha", chakra = 80),
                NinjaEntity(name = "Kakashi", village = "Konoha", chakra = 85),
                NinjaEntity(name = "Madara", village = "Uchiha", chakra = 100),
                NinjaEntity(name = "Boruto", village = "Konoha", chakra = 85),
                NinjaEntity(name = "Sarada", village = "Konoha", chakra = 80),
                NinjaEntity(name = "Kawaki", village = "Kara", chakra = 90),
                NinjaEntity(name = "Isshiki", village = "Otsutsuki", chakra = 100),
                NinjaEntity(name = "Kashin Koji", village = "Kara", chakra = 95)
            )

            ninjas.forEach {
                repository.insert(it)
            }
        }
    }

    fun updateNinja(ninja: NinjaEntity) {
        viewModelScope.launch {
            repository.update(ninja)
        }
    }

    fun deleteNinja(ninja: NinjaEntity) {
        viewModelScope.launch {
            repository.delete(ninja)
        }
    }

    fun deleteAllNinjas() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}