package com.tonpackage.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow
@Dao
interface NinjaDao {

    @Query("SELECT * FROM ninja")
    fun getAll(): Flow<List<NinjaEntity>>

    @Query("SELECT * FROM ninja WHERE name LIKE '%' || :query || '%'")
    fun search(query: String): Flow<List<NinjaEntity>>

    @Insert
    suspend fun insert(ninja: NinjaEntity)

    @Update
    suspend fun update(ninja: NinjaEntity)

    @Delete
    suspend fun delete(ninja: NinjaEntity)

    @Query("DELETE FROM ninja")
    suspend fun deleteAll()
}