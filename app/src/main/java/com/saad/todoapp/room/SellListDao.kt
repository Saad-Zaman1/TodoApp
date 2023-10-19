package com.saad.todoapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface SellListDao {
    @Insert
    suspend fun addSellItem(item: SellListEntity)

    @Query("select * from ItemToSell")
    fun getSellItem(): LiveData<List<SellListEntity>>
}