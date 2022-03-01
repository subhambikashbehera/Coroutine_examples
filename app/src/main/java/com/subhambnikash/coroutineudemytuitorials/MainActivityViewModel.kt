package com.subhambnikash.coroutineudemytuitorials

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(count:Int):ViewModel() {

    private val respositoties=Repositorities()
   // val users:MutableLiveData<ArrayList<modelClass>> = MutableLiveData()

    val users= liveData(Dispatchers.IO) {
        val result=respositoties.getUserData()
        emit(result)
    }



//    fun getUserData(){
//        viewModelScope.launch {
//            var result: ArrayList<modelClass>
//            withContext(Dispatchers.IO){
//               result= respositoties.getUserData()
//            }
//            users.value=result
//        }
//
//
//    }

}