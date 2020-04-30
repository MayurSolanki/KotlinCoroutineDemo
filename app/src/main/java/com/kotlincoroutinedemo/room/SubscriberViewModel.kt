package com.kotlincoroutinedemo.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 10:46 PM.
 */
class SubscriberViewModel(val repository: SubscriberRepository) :ViewModel() {

    val subscribers = repository.subscribers

    fun insert( subscriber: Subscriber){

        viewModelScope.launch{
              repository.insert(subscriber)
        }

    }

    fun deleteAll(){
        viewModelScope.launch {
            repository.clearAll()
        }
    }
}