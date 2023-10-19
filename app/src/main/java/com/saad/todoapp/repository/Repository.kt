package com.saad.todoapp.repository

import androidx.lifecycle.LiveData
import com.saad.todoapp.models.CallModel
import com.saad.todoapp.retrofit.RetrofitService
import com.saad.todoapp.room.SellListDao
import com.saad.todoapp.room.SellListEntity
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val sellDao: SellListDao,
    private val retrofitService: RetrofitService
) {

    suspend fun addSellItem(item: SellListEntity) {
        return sellDao.addSellItem(item)
    }

    fun getSellItem(): LiveData<List<SellListEntity>> {
        return sellDao.getSellItem()
    }

    fun getBuyData(): LiveData<Response<List<SellListEntity>>> {
        return retrofitService.getBuy()
    }

    fun getCallData(): LiveData<Response<List<CallModel>>> {
        return retrofitService.getCall()
    }
}