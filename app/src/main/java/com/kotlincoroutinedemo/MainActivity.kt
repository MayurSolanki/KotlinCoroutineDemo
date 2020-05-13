package com.kotlincoroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.kotlincoroutinedemo.vmld.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class MainActivity : AppCompatActivity() {

    private var count : Int = 0
    private var TAG : String = "Kotlin Coroutine"
    lateinit var  mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


//        mainActivityViewModel.callApiGetUserData()
//        mainActivityViewModel.liveData.observe(this, Observer {
//            userData->
//
//            userData.forEach{
//                Log.i(TAG," Live data Iterate ${it.name}")
//            }
//
//        })





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


 //          SequenceExecution()
//          CoroutineAsyncAwait()
//           CoroutineLazy()
//         timeOutCoroutine()
//        runBlockingBuilder()





        CoroutineScope(Dispatchers.Main).launch {
            makeFlow().collect {

            }
        }


    }

    fun makeFlow() = flow<String>{

        emit("A")

    }

    private fun runBlockingBuilder() {
        // some times need to block main thread

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

    private fun CoroutineLazy(){
        // Only invoke by await, Deferred , run paraller
        CoroutineScope(Dispatchers.Main).launch {

            Log.i(TAG,"  Start stock  .....")



//                          Async Await , Run in parallel
            val stock1  = async(start = CoroutineStart.LAZY)  {
                getStock1()
            }
            val stock2  = async (start = CoroutineStart.LAZY) {
                getStock2()
            }



            delay(4000)
            Log.i(TAG," ============= just before await ==========")

            val total : Int = stock1.await() + stock2.await()

            tv_count.text = total.toString()


            Log.i(TAG," Total is $total")

        }
    }

    private fun CoroutineAsyncAwait(){
        //  run sequentially
        CoroutineScope(Dispatchers.Main).launch {

            Log.i(TAG,"  Start stock  .....")


//               Async Await , Run in parallel
            val stock1  = async(Dispatchers.IO)  {
                getStock1()
            }
            val stock2  = async(Dispatchers.IO)  {
                getStock2()
            }



//            delay(4000)
//            Log.i(TAG," ============= just before await ==========")

            val total : Int = stock1.await() + stock2.await()

            tv_count.text = total.toString()


            Log.i(TAG," Total is $total")

        }
    }

    private fun timeOutCoroutine(){
        CoroutineScope(Dispatchers.Main).launch {
            
//            withTimeoutOrNull(5000){
//                for(i in 1..100000){
//
//                    delay(1000)
//                    Log.i(TAG," Total is $i")
//                }
//            }
        }
    }

    private fun SequenceExecution(){

        //                  Sequential Decomposition, This is not parallel Decomposition, Old approach one by one
//                 val stock1 : Int = getStock1()
//                 val stock2 : Int = getStock2()
//                 val total : Int = stock1 + stock2
//            Log.i(TAG," Total is $total")

    }




    private suspend fun getStock1():Int{
        Log.i(TAG," getStock1 start")

        delay(3000)
        Log.i(TAG," getStock1 returned")
        return 101
    }
    private suspend fun getStock2():Int{
        Log.i(TAG," getStock2 start")

        delay(5000)
        Log.i(TAG," getStock2 returned ")
        return 102
    }
}


