package br.com.confchat.auth.data.database.room.userdb

import androidx.room.TypeConverter
import java.util.Date

class Convertes {
    @TypeConverter
    fun toDate(it:Long): Date {
        if(it == null) {
            return Date()
        }
        return Date(it)
    }
    @TypeConverter
    fun fromDate(it:Date):Long{
        return it.time
    }
}