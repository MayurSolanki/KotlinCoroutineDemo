package com.kotlincoroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class MainActivity : AppCompatActivity() {

    private var count : Int = 0
    private var TAG : String = "Kotlin Coroutine"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        btn_click_here.setOnClickListener {
//            tv_count.text = count++.toString()
//        }
//
//        btn_download_user_data.setOnClickListener{
//
//            CoroutineScope(Dispatchers.IO).launch {
//                downloadUserData()
//            }
//        }

        CoroutineScope(Dispatchers.Main).launch {

            Log.i(TAG,"  Start stock ")

//                   Deferred , Execute One By One
//                 val stock1 : Int = getStock1()
//                 val stock2 : Int = getStock2()
//                 val total : Int = stock1 + stock2
//            Log.i(TAG," Total is $total")

//                          Async Await , Run in parallel
                val stock1  = async (Dispatchers.IO)  {getStock1() }
                 val stock2  = async (Dispatchers.IO) {getStock2()  }

                 val total : Int = stock1.await() + stock2.await()

               withContext(Dispatchers.Main){
                  tv_count.text = total.toString()

               }

               Log.i(TAG," Total is $total")

        }
    }


//    private fun downloadUserData() {
//        for(i in 1..100000){
//            Log.i(TAG," Download User $i in ${Thread.currentThread().name}")
//        }
//    }

//    private suspend fun downloadUserData() {
//         for(i in 1..100000){
//             withContext(Dispatchers.Main){
//                 tv_message.text = " Download User $i in ${Thread.currentThread().name}"
//
//             }
//             delay(2000)
//         }
//    }

    private suspend fun getStock1():Int{
        delay(5000)
        Log.i(TAG," getStock1 returned")
        return 101
    }
    private suspend fun getStock2():Int{
        delay(8000)
        Log.i(TAG," getStock2 returned ")
        return 102
    }
}
