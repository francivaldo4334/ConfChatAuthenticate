package br.com.confchat.auth.presenter

import android.graphics.Rect
import android.os.Bundle
import android.view.View
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
import br.com.confchat.auth.presenter.ui.components.ComponentDialogPin
import br.com.confchat.auth.presenter.ui.components.ComponentPageList
import br.com.confchat.auth.presenter.ui.components.ComponentTop
import br.com.confchat.auth.presenter.ui.theme.ConfChatAuthTheme
import br.com.confchat.auth.presenter.viewmodel.model.PwdItem
import br.com.confchat.auth.presenter.viewmodel.model.TotpItem

class HomeActivity : ComponentActivity() {
    var kbGone = false
    var openSearch by mutableStateOf(false)
    var search by mutableStateOf("")
    var kbOpened: () -> Unit = {
        openSearch = true
    }
    var kbClosed: () -> Unit = {
        search = ""
        openSearch = false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfChatAuthTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var openInsertPin by remember { mutableStateOf(false) }
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
                        ComponentTop(openSearch,search){
                            search = it
                        }
                        //LISTS
                        ComponentPageList(search,listTotp,listPwd)
                    }
                    if (openInsertPin) {
                        ComponentDialogPin() {
                            openInsertPin = false
                        }
                    }
                    LaunchedEffect(key1 = Unit, block = {
                        openInsertPin = true
                    })
                }
            }
        }
        setupKeyboardDetection(findViewById<View>(android.R.id.content))
    }
    fun setupKeyboardDetection(contentView: View) {
        contentView.viewTreeObserver.addOnGlobalLayoutListener {
            val r = Rect()
            contentView.getWindowVisibleDisplayFrame(r)
            val screenHeight = contentView.rootView.height
            val keypadHeight = screenHeight - r.bottom
            if (keypadHeight > screenHeight * 0.15) { // 0.15 ratio is perhaps enough to determine keypad height.
                kbGone = false
                kbOpened()
            } else if(!kbGone) {
                kbGone = true
                kbClosed()
            }
        }
    }
}