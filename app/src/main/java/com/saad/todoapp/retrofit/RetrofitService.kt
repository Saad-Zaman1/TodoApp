package com.saad.todoapp.retrofit

import androidx.lifecycle.LiveData
import com.saad.todoapp.models.CallModel
import com.saad.todoapp.room.SellListEntity
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("buy")
    fun getBuy(): LiveData<Response<List<SellListEntity>>>

    @GET("call")
    fun getCall(): LiveData<Response<List<CallModel>>>
}