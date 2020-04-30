package com.kotlincoroutinedemo

import kotlinx.coroutines.*

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 12:01 PM.
 */
class UserDataManagerStruct {

    var count = 0
    lateinit var deferred : Deferred<Int>

    suspend fun   getUserData():Int{

        // Child Coroutine
        coroutineScope {
            launch (Dispatchers.IO){
                  delay(1000)

                  count = 50
            }

            deferred =  async (Dispatchers.IO){
              delay(3000)
                 return@async 70

            }
        }

        return count + deferred.await()
    }

    // This will retun correct out put but somtimes if exception occur in function then may be output not as expected
    // So Unstructured concurrency can be eliminated by the Structured Concurrency
    // Structured Concurrency is cancellable and allow exception handling
    // coroutineScope (Small c) , is suspend function used in Structured Concurrency
    suspend fun getUserDataAsync() : Int {
        var count = 0

        // Async always return deferred Value
      val deferred =  CoroutineScope(Dispatchers.IO).async {

            delay(2000)

          return@async    90
        }

        return  count + deferred.await()
    }
}