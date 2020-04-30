package com.kotlincoroutinedemo.room

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 10:43 PM.
 */
class SubscriberRepository(private var subscriberDao:SubscriberDao) {

    val subscribers = subscriberDao.getAllSubscriber()

    suspend fun insert(subscriber :Subscriber){
           subscriberDao.insert(subscriber)
    }

    suspend fun clearAll(){
        subscriberDao.deleteAll()
    }
}