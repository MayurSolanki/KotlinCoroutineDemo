package com.kotlincoroutinedemo

import com.kotlincoroutinedemo.vmld.User
import kotlinx.coroutines.delay

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 6:14 PM.
 */
class UserRepository {

    suspend fun getDataFromApi() : List<User>{

        delay(4000)

        var list : List<User> = mutableListOf(
            User(1, "ABC"),
            User(2, "dasdsa"),
            User(3, "ewrew"),
            User(4, "uoiuiouo"),
            User(5, "xcvmx")
        )

        return list
    }
}