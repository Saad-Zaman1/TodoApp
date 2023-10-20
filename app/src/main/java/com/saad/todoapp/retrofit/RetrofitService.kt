package com.saad.todoapp.retrofit

import com.saad.todoapp.models.CallModel
import com.saad.todoapp.room.SellListEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("buy/")
    suspend fun getBuy(@Query("buy") buy: String): Response<List<SellListEntity>>

    @GET("call/")
    suspend fun getCallsData(@Query("call") call: String): Response<List<CallModel>>

}