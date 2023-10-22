package br.com.confchat.auth.domain.repository.contract

interface ITotpDomainRepository {
    fun generateCode(secret: String, counter: Long):String
}