package com.kotlincoroutinedemo

import kotlinx.coroutines.*

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 12:01 PM.
 */
class UserDataManagerUnstruct {

    // This function does not return 50, because function was called form CoroutineScope and return from CoroutineScope

    suspend fun getUserData(): Int {
        var count = 0

        CoroutineScope(Dispatchers.IO).launch {

            delay(2000)

            count = 50
        }
        return count
    }

    // This will retun correct out put but somtimes if exception occur in function then may be output not as expected
    // So Unstructured concurrency can be eliminated by the Structured Concurrency
    // Structured Concurrency is cancellable and allow exception handling
    // coroutineScope (Small c) , is suspend function used in Structured Concurrency
    // coroutineScope and supervisorScope will wait for child coroutines to complete.

    suspend fun getUserDataAsync(): Int {

        var count = 0

        // Async always return deferred Value
        val deferred = CoroutineScope(Dispatchers.IO).async {

            delay(2000)

            return@async 90
        }

        return count + deferred.await()
    }
}