package br.com.confchat.auth.presenter.viewmodel.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.confchat.auth.domain.enums.StatePin
import br.com.confchat.auth.domain.repository.contract.IUserDomainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class UserViewModel @Inject constructor(private val domain:IUserDomainRepository) : ViewModel() {
    fun isFirstAccess(response:(StatePin)->Unit){
        viewModelScope.launch(Dispatchers.IO) {
            val userDb = domain.getAccess()
            viewModelScope.launch(Dispatchers.Main) {
                if(userDb.first.isEmpty())
                    response(StatePin.IS_FIRST)
                else if(userDb.second.isEmpty())
                    response(StatePin.NOT_SET_PIN)
                else
                    response(StatePin.NONE)
            }
        }
    }
    fun createPin(it:String){
        domain.setAccess(Pair("user_db",it))
    }

    fun setPin(it: String) {
        viewModelScope.launch(Dispatchers.IO) {
            domain.setAccessPassword(it)
        }
    }
}