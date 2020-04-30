package com.kotlincoroutinedemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_job_coroutine.*
import kotlinx.coroutines.*

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 10:24 AM.
 * */

// Background Job
// Job State : New, Active, Completing, cancelling, cancelled, cancelled, completed
class JobCoroutineActivity : AppCompatActivity() {
    lateinit var job1 : Job
    private var TAG : String = "Kotlin Coroutine"
    lateinit var deferred1: Deferred<Int>
    var returnValue : Int = 0

    override fun onCreate(savedInstanceState: Bundle?)   {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_coroutine)

//       job1 =   CoroutineScope(Dispatchers.Main).launch {
//           downloadData()
//        }

        job1 =   CoroutineScope(Dispatchers.Main).launch {
            deferred1 =  async () {
                downloadData2()
            }

            returnValue = deferred1.await()
            Log.i(TAG," Return Value :  $returnValue")

        }

        btn_cancel.setOnClickListener{
            job1.cancel()
        }
        btn_status.setOnClickListener{
//            if(job1.isActive){
//                tv_status.text = "Active"
//            }else if(job1.isCancelled){
//                tv_status.text = "Cancelled"
//
//            }else if(job1.isCompleted){
//                tv_status.text = "Completed"
//
//            }

            if(deferred1.isActive){
                tv_status.text = "Active"
            }else if(deferred1.isCancelled){
                tv_status.text = "Cancelled"

            }else if(deferred1.isCompleted){
                tv_status.text = "Completed"

            }
        }
    }

    private suspend fun downloadData(){
        withContext(Dispatchers.IO){
            repeat(10){
                Log.i(TAG," Download Data Times:  $it")
                delay(2000)

            }
        }
    }

    private suspend fun downloadData2() : Int{
        var i  = 0
        withContext(Dispatchers.IO){
            repeat(10){
                Log.i(TAG," Download Data Times:  $it")
                delay(2000)
                i++

            }
        }

        return i
    }
}