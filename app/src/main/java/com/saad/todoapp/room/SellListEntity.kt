package com.saad.todoapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ItemToSell")
class SellListEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val price: String,
    val quantity: String,
    val type: String
)