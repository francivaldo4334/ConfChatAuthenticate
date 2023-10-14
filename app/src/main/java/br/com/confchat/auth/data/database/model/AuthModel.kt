package br.com.confchat.auth.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.intellij.lang.annotations.Identifier

@Entity(tableName = "auth_inform")
data class AuthModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name = "db_name")
    val dbName:String
)