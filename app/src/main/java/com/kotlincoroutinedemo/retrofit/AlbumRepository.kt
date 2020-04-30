package com.kotlincoroutinedemo.retrofit

import retrofit2.Response

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 8:25 PM.
 */
class AlbumRepository {

    var albumService: AlbumService = RetrofitInstance.albumService

    suspend fun getAlbumData( id : Int) : Response<Album>{
      return  albumService.getAlbum(id)
    }
}