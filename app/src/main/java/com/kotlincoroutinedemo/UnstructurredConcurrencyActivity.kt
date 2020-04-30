package com.kotlincoroutinedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_unstructurred_concurrency.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 11:59 AM.
 */
class UnstructurredConcurrencyActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unstructurred_concurrency)

        btn_download_user_data.setOnClickListener{
            tv_message.text = ""
            CoroutineScope(Dispatchers.Main).launch {
                tv_message.text = UserDataManagerStruct().getUserData().toString()
            }

        }

    }
}