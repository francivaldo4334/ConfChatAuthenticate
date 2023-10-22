package br.com.confchat.auth.domain.repository.contract

interface IUserDomainRepository {
    fun setAccessPassword(it:String)
    fun setDatabaseName(it:String)
    fun getAccess():Pair<String,String>
    fun setAccess(it:Pair<String, String>)
}