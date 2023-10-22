package br.com.confchat.auth.presenter.viewmodel.repository

import androidx.lifecycle.ViewModel
import br.com.confchat.auth.domain.repository.contract.IUserDomainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class UserViewModel @Inject constructor(private val domain:IUserDomainRepository) : ViewModel() {
    fun isFirstAccess():Boolean{
        val userDb = domain.getAccess()
        return userDb.first.isEmpty()
    }
    fun createPin(it:String){

    }
}