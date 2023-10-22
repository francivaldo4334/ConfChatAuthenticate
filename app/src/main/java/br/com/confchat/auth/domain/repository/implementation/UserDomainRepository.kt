package br.com.confchat.auth.domain.repository.implementation

import br.com.confchat.auth.data.database.dao.UserDao
import br.com.confchat.auth.data.database.model.AuthModel
import br.com.confchat.auth.domain.repository.contract.IUserDomainRepository

class UserDomainRepository constructor(private val db:UserDao) : IUserDomainRepository {
    companion object {
        private var PASSWORD_DB = ""
    }
    override fun setAccessPassword(it: String) {
        PASSWORD_DB = it
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