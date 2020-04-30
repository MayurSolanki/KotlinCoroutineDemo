package com.kotlincoroutinedemo.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlincoroutinedemo.R
import kotlinx.android.synthetic.main.activity_room.*

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 10:16 PM.
 */
class RoomActivity : AppCompatActivity() {

    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val dao = SubscriberDatabase.getInstance(applicationContext).subscriberDao
       val repository =  SubscriberRepository(dao)
       val  viewModelFactory = SubcriberViewModelFactory(repository)

        subscriberViewModel = ViewModelProvider(this,viewModelFactory).get(SubscriberViewModel::class.java)

        displaySubscriberList()

        btn_save.setOnClickListener{
            val subscriber= Subscriber(0,et_name.text.toString().trim(),et_email.text.toString().trim())
            subscriberViewModel.insert(subscriber)

        }

        btn_clear.setOnClickListener{
            subscriberViewModel.deleteAll()
        }
    }

    private fun displaySubscriberList(){
        subscriberViewModel.subscribers.observe(this, Observer {
            tv_db_data.text = it.toString()

        })
    }


}