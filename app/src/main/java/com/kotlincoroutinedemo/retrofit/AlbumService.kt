package com.kotlincoroutinedemo.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 8:20 PM.
 */
interface AlbumService{
    @GET(value = "/albums/{id}")
    suspend fun getAlbum(@Path(value = "id") albumId:Int) : Response<Album>
}