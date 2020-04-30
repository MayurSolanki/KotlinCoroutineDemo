package com.kotlincoroutinedemo.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 10:27 PM.
 */

@Dao
interface SubscriberDao {

    @Insert
    suspend fun insert(subscriber: Subscriber)

    @Query("DELETE FROM subscriber_tbl")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber_tbl")
    fun getAllSubscriber() : LiveData<List<Subscriber>>

}