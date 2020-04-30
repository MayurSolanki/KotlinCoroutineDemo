package com.kotlincoroutinedemo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kotlincoroutinedemo.vmld.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_life_cycle_scope.*

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 7:25 PM.
 */
class LifecycleScopeActivity : AppCompatActivity() {

    lateinit var   mainActivityViewModel: MainActivityViewModel
    private var TAG : String = "Kotlin Coroutine"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_scope)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        // Observe data using live data scope, Very Efficiently
                mainActivityViewModel.user.observe(this, Observer {
                userData->
                userData.forEach{
                progress_circular.visibility = View.GONE
                Log.i(TAG," Live data Iterate ${it.name}")
            }

        })


        // Automatically manage according to lifecycle of the activity, No need to stop or cancel manually
//        lifecycleScope.launch(Dispatchers.IO){
////            delay(5000)
//            mainActivityViewModel.callApiGetUserData()
//            progress_circular.visibility = View.VISIBLE
////            delay(8000)
////            progress_circular.visibility = View.GONE
//        }
//
//        mainActivityViewModel.liveData.observe(this, Observer {
//                userData->
//               userData.forEach{
//                progress_circular.visibility = View.GONE
//                Log.i(TAG," Live data Iterate ${it.name}")
//            }
//
//        })

        lifecycleScope.launchWhenCreated {
            // For just once, when created
        }

        lifecycleScope.launchWhenStarted {
          // when start actvity
        }

        lifecycleScope.launchWhenResumed {
           //launch when resumed
        }




    }
}