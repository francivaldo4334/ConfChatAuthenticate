package br.com.confchat.auth.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.confchat.auth.data.database.model.AuthModel

@Dao
interface UserDao {
    @Query("SELECT * FROM auth_inform WHERE id = 1")
    fun get():AuthModel
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(it:AuthModel)
}