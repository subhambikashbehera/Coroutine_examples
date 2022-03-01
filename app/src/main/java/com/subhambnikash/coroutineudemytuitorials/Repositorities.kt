package com.subhambnikash.coroutineudemytuitorials

import kotlinx.coroutines.delay

class Repositorities {

    suspend fun getUserData():ArrayList<modelClass>{
        delay(8000)
        val user = arrayListOf<modelClass>()
       for (i in 0..50){
           user.add(modelClass("subham",i))
       }
        return user
    }
}