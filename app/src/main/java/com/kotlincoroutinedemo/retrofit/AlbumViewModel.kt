package com.kotlincoroutinedemo.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import retrofit2.Response

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 8:28 PM.
 */
class AlbumViewModel : ViewModel() {

    val albumRepository :AlbumRepository = AlbumRepository()

     var album = liveData<Response<Album>> {
         val rcvdAlbum : Response<Album> = albumRepository.getAlbumData(5)

          emit(rcvdAlbum)
     }
}