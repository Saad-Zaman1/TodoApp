package com.saad.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SellListEntity::class], version = 1)
abstract class SellListDatabase : RoomDatabase() {
    abstract fun SellListDao(): SellListDao
}