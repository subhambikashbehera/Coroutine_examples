package com.subhambnikash.coroutineudemytuitorials

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class viewModelFactory(var count:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when(modelClass){
            MainActivityViewModel::class.java->{
                MainActivityViewModel(count)
            }
            else->throw IllegalArgumentException("error")
        } as T
    }
}