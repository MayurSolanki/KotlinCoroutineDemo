package com.kotlincoroutinedemo.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 8:16 PM.
 */
object RetrofitInstance{

    val albumService by lazy{
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(AlbumService::class.java)
    }
}

