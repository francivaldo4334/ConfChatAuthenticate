package br.com.confchat.auth.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.confchat.auth.domain.enums.StatePin
import br.com.confchat.auth.presenter.ui.components.ComponentCreatePin
import br.com.confchat.auth.presenter.ui.components.ComponentDialogNewCredential
import br.com.confchat.auth.presenter.ui.components.ComponentDialogPin
import br.com.confchat.auth.presenter.ui.components.ComponentPageList
import br.com.confchat.auth.presenter.ui.components.ComponentTop
import br.com.confchat.auth.presenter.ui.screens.ScreenNewPwd
import br.com.confchat.auth.presenter.ui.screens.ScreenNewTotp
import br.com.confchat.auth.presenter.ui.theme.ConfChatAuthTheme
import br.com.confchat.auth.presenter.viewmodel.model.PwdItem
import br.com.confchat.auth.presenter.viewmodel.model.TotpItem
import br.com.confchat.auth.presenter.viewmodel.repository.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfChatAuthTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val viewModel: UserViewModel = hiltViewModel()

                    var openInsertPin by remember { mutableStateOf(false) }
                    var openNewTotp by remember { mutableStateOf(false) }
                    var openNewPwd by remember { mutableStateOf(false) }
                    var openDialogCredencial by remember { mutableStateOf(false) }
                    var isCreatePin by remember{ mutableStateOf(false) }
                    viewModel.isFirstAccess{
                        when(it){
                            StatePin.NOT_SET_PIN ->{
                                openInsertPin = true
                            }
                            StatePin.IS_FIRST ->{
                                isCreatePin = true
                            }
                            else ->{}
                        }
                    }
                    val listTotp = buildList<TotpItem> {
                        add(TotpItem("teste","teste","000 000",0.4f,1))
                        add(TotpItem("teste","teste","000 000",0.4f,1))
                        add(TotpItem("teste","teste","000 000",0.4f,1))
                    }
                    val listPwd = buildList<PwdItem> {
                        add(PwdItem("Teste","1244","site.com.br"))
                        add(PwdItem("Teste","1244","site.com.br"))
                        add(PwdItem("Teste","1244","site.com.br"))
                        add(PwdItem("Teste","1244","site.com.br"))
                        add(PwdItem("Teste","1244","site.com.br"))
                        add(PwdItem("Teste","1244","site.com.br"))
                    }
                    Column {
                        //TOP
                        ComponentTop(
                            onNewTotp = {
                                openNewTotp = true
                            },
                            onNewPwd = {
                                openNewPwd = true
                            },
                            onOpenQRScanner = {
                                /*TODO*/
                            },
                            onGenerateCredential = {
                                /*TODO*/
                                openDialogCredencial = true
                            },
                        )
                        //LISTS
                        ComponentPageList(listTotp,listPwd)
                    }
                    if (openInsertPin) {
                        ComponentDialogPin() {
                            viewModel.setPin(it)
                            openInsertPin = false
                        }
                    }
                    if(openDialogCredencial){
                        ComponentDialogNewCredential(
                            "USER",//TODO: mostrar usuario
                            "PASS"//TODO: mostrar senha
                        ){
                            openDialogCredencial = false
                        }
                    }
                    ScreenNewTotp(
                        open = openNewTotp,
                        onNew = { issuer, accountName, secretKey ->
                            /*TODO*/
                        }
                    ) {
                        openNewTotp = false
                    }
                    ScreenNewPwd(
                        open = openNewPwd,
                        onNew = { user,pwd->
                            /*TODO*/
                            openDialogCredencial = true
                        }
                    ) {
                        openNewPwd = false
                    }
                    if(isCreatePin){
                        ComponentCreatePin(){
                            viewModel.createPin(it)
                        }
                    }
                }
            }
        }
    }
}