package com.saad.todoapp.room

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    private var INSTANCE: SellListDatabase? = null
    fun getInstance(context: Context): SellListDatabase {
        if (INSTANCE == null) {
            synchronized(SellListDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            SellListDatabase::class.java,
            "ItemToSel"
        ).build()

}