package com.tonpackage.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ninja")
data class NinjaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,
    val village: String,
    val chakra: Int
)