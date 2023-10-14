package br.com.confchat.auth.data.database.room.confchatauth

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.confchat.auth.data.database.model.AuthModel

@Database(
    entities = [
        AuthModel::class
    ],
    version = 1
)
@TypeConverters(Convertes::class)
abstract class AuthenticationDb : RoomDatabase()   {
    companion object{
        private lateinit var INSTANCE: AuthenticationDb
        fun getInstance(context: Context) : AuthenticationDb {
            if(!Companion::INSTANCE.isInitialized) {
                synchronized(AuthenticationDb::class.java){
                    INSTANCE = Room.databaseBuilder(
                        context,
                        AuthenticationDb::class.java,
                        "confchat_db_auth"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
        private val MIGRATION_1_2: Migration = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {}
        }
    }
}