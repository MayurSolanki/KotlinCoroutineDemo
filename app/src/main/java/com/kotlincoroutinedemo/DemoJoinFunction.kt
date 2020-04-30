package com.kotlincoroutinedemo

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 12:41 PM.
 */
//// suspend the child coroutine until job finish
class DemoJoinFunction {


    private var TAG : String = "Kotlin Coroutine"


    suspend fun test1(){
        Log.i(TAG,"  before child start")

        // Child coroutine thread
         coroutineScope {

           val  job   = launch (Dispatchers.IO){
                 Log.i(TAG,"  before delay")
                  delay(2000)
                 Log.i(TAG," After Delay")
           }

             job.join()   // suspend the child coroutine until job finish

             Log.i(TAG," bottom of test1 ")


         }

    }
}