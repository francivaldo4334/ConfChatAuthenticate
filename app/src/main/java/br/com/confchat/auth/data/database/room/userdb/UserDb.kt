package br.com.confchat.auth.data.database.room.userdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.confchat.auth.data.database.model.AuthModel
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

@Database(
    entities = [
        AuthModel::class
    ],
    version = 1
)
@TypeConverters(Convertes::class)
abstract class UserDb : RoomDatabase()   {
    companion object{
        private lateinit var INSTANCE: UserDb
        fun getInstance(context: Context,dbName:String? = null,pwd:String? = null) : UserDb {
            if(!Companion::INSTANCE.isInitialized && pwd != null && dbName != null) {
                val passphrase = SQLiteDatabase.getBytes(pwd.toCharArray())
                val factory = SupportFactory(passphrase)
                synchronized(UserDb::class.java){
                    INSTANCE = Room
                        .databaseBuilder(
                            context,
                            UserDb::class.java,
                            dbName
                        )
                        .openHelperFactory(factory)
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