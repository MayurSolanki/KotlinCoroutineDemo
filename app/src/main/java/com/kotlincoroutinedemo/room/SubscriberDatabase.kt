package com.kotlincoroutinedemo.room

import android.content.Context
import android.view.SurfaceView
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 10:34 PM.
 */

@Database(entities = [Subscriber::class], version = 1, exportSchema = false)
abstract class SubscriberDatabase : RoomDatabase() {

    abstract val  subscriberDao:SubscriberDao

    companion object{
        @Volatile
        private var INSTANCE : SubscriberDatabase? = null

         fun getInstance( context :Context):SubscriberDatabase{
                synchronized(this){

                    if(INSTANCE == null){
                        INSTANCE = Room.databaseBuilder(context.applicationContext,SubscriberDatabase::class.java,"subscriberrs.db").fallbackToDestructiveMigration().build()
                    }

                    return INSTANCE as SubscriberDatabase
                }
         }
    }

}