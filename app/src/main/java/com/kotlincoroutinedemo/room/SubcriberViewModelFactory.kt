package com.kotlincoroutinedemo.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 10:52 PM.
 */
open class SubcriberViewModelFactory(val repository: SubscriberRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
           if(modelClass.isAssignableFrom(SubscriberViewModel::class.java)){
               return SubscriberViewModel(repository) as T
           }
        throw IllegalArgumentException("Unknown Viewmodel class")
      }
}