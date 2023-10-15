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
import br.com.confchat.auth.presenter.ui.components.ComponentDialogPin
import br.com.confchat.auth.presenter.ui.components.ComponentPageList
import br.com.confchat.auth.presenter.ui.components.ComponentTop
import br.com.confchat.auth.presenter.ui.theme.ConfChatAuthTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfChatAuthTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var openInsertPin by remember { mutableStateOf(false) }
                    Column {
                        //TOP
                        ComponentTop()
                        //LISTS
                        ComponentPageList()
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
    }
}