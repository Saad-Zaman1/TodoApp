package com.saad.todoapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.saad.todoapp.models.CallModel
import com.saad.todoapp.retrofit.RetrofitService
import com.saad.todoapp.room.SellListDao
import com.saad.todoapp.room.SellListEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val sellDao: SellListDao,
    private val retrofitService: RetrofitService
) {
    private val callData = MutableLiveData<List<CallModel>>()
    private val buyData = MutableLiveData<List<SellListEntity>>()
    val callLiveData: LiveData<List<CallModel>>
        get() = callData

    val buyLiveData: LiveData<List<SellListEntity>>
        get() = buyData


    suspend fun addSellItem(item: SellListEntity) {
        return sellDao.addSellItem(item)
    }

    fun getSellItem(): LiveData<List<SellListEntity>> {
        return sellDao.getSellItem()
    }


    suspend fun getBuyData(buy: String) {
        val result = retrofitService.getBuy(buy)
        if (result.isSuccessful) {
            buyData.postValue(result.body())
        }
    }

    suspend fun getCallData(call: String) {
        val result = retrofitService.getCallsData(call)
        if (result.isSuccessful) {
            callData.postValue(result.body())
        }

    }
}