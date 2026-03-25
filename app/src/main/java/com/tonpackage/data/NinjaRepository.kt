package com.tonpackage.data

import com.tonpackage.data.local.NinjaDao
import com.tonpackage.data.local.NinjaEntity
import kotlinx.coroutines.flow.Flow

class NinjaRepository(private val dao: NinjaDao) {

    fun getAll(): Flow<List<NinjaEntity>> = dao.getAll()

    fun search(query: String): Flow<List<NinjaEntity>> = dao.search(query)

    suspend fun insert(ninja: NinjaEntity) = dao.insert(ninja)

    suspend fun update(ninja: NinjaEntity) = dao.update(ninja)

    suspend fun delete(ninja: NinjaEntity) = dao.delete(ninja)

    suspend fun deleteAll() = dao.deleteAll()
}