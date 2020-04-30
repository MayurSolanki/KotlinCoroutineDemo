package com.kotlincoroutinedemo.retrofit

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlincoroutinedemo.R
import kotlinx.android.synthetic.main.activity_album.*

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 8:31 PM.
 */
class AlbumActivity : AppCompatActivity() {

    lateinit var albumViewModel: AlbumViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        albumViewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)


        progress_circular.visibility = View.VISIBLE

        albumViewModel.album.observe(this, Observer {
            tv_album_detail.text = it.body()?.title
            progress_circular.visibility = View.GONE
        })
    }
}