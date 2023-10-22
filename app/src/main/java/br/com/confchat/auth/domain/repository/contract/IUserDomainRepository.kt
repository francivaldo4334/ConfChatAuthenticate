package br.com.confchat.auth.domain.repository.contract

interface IUserDomainRepository {
    fun setAccess(it:String)
    fun getAccess():Pair<String,String>
}