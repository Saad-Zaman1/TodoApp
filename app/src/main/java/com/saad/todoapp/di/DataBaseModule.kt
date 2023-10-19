package com.saad.todoapp.di

import android.content.Context
import androidx.room.Room
import com.saad.todoapp.room.SellListDao
import com.saad.todoapp.room.SellListDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideSellDao(database: SellListDatabase): SellListDao {
        return database.SellListDao()
    }

    @Provides
    @Singleton
    fun providesRoomDb(@ApplicationContext appContext: Context): SellListDatabase {
        return Room.databaseBuilder(
            appContext,
            SellListDatabase::class.java,
            "ItemToSell"
        ).build()
    }
}