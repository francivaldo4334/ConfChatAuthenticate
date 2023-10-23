package br.com.confchat.auth.domain.repository.implementation

import android.content.Context
import br.com.confchat.auth.data.database.dao.UserDao
import br.com.confchat.auth.data.database.model.AuthModel
import br.com.confchat.auth.data.database.room.userdb.UserDb
import br.com.confchat.auth.domain.repository.contract.IUserDomainRepository

class UserDomainRepository constructor(private val db:UserDao,private val context:Context) : IUserDomainRepository {
    companion object {
        private var PASSWORD_DB = ""
    }
    override fun setAccessPassword(it: String) {
        PASSWORD_DB = it
        var user = db.get()
        UserDb.getInstance(context = context, dbName = user.dbName,pwd = it)
    }

    override fun setDatabaseName(it: String) {
        val newDb = AuthModel(
            id = 1,
            dbName = it
        )
        db.insert(newDb)
    }

    override fun getAccess(): Pair<String, String> {
        try {
            val userDb = db.get()
            return Pair(userDb.dbName, PASSWORD_DB)
        }
        catch (e:Exception){
            return Pair("","")
        }
    }
    override fun setAccess(it:Pair<String, String>) {
        setAccessPassword(it.second)
        setDatabaseName(it.first)
    }
}