package com.subhambnikash.coroutineudemytuitorials

import kotlinx.coroutines.*

class StrucuiredConcurrency {

    lateinit var defered:Deferred<Int>
    var count=0

    suspend fun getUserData():Int{

        coroutineScope {
            launch(Dispatchers.IO) {
                delay(6000)
                count=60
            }
        }

        coroutineScope {
            defered=async(Dispatchers.IO){
                delay(5000)
                return@async 50
            }
        }

        return count+defered.await()
    }

}