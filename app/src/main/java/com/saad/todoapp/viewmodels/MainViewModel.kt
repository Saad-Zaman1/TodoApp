package com.saad.todoapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saad.todoapp.models.CallModel
import com.saad.todoapp.repository.Repository
import com.saad.todoapp.room.SellListEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    suspend fun addSellItem(item: SellListEntity) {
        return repository.addSellItem(item)
    }

    fun getSellItem(): LiveData<List<SellListEntity>> {
        return repository.getSellItem()
    }

    fun getBuyData(): LiveData<Response<List<SellListEntity>>> {
        return repository.getBuyData()
    }

    fun getCallData(): LiveData<Response<List<CallModel>>> {
        return repository.getCallData()
    }

    var name = MutableLiveData<String>()
    var price = MutableLiveData<String>()
    var quantity = MutableLiveData<String>()
    var type = MutableLiveData<String>()


    fun onSave() {
        val obj = SellListEntity(
            0,
            name.value ?: "",
            price.value ?: "",
            quantity.value ?: "",
            type.value ?: "",
        )
        Log.i("onSaveClick", "111")
        CoroutineScope(Dispatchers.IO).launch {
            addSellItem(obj)
            Log.i("onSaveClick", "Inside corotine")
        }
        name.value == ""
        price.value == ""
        quantity.value == ""
        type.value == ""
    }
}