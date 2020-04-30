package com.kotlincoroutinedemo.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Mayur Solanki (mayursolanki120@gmail.com) on 30/04/20, 10:24 PM.
 */
@Entity(tableName = "subscriber_tbl")
data  class Subscriber(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="subscriber_id")
    val subscriberId:Int,
    @ColumnInfo(name="subscriber_name")
    var name : String,
    @ColumnInfo(name="subscriber_email")
    var email: String) {

    override fun toString(): String {
        return "\n name='$name', \nemail='$email'\n"
    }
}