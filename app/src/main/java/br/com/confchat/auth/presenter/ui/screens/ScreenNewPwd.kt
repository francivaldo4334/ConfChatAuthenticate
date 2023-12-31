package br.com.confchat.auth.presenter.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.confchat.auth.presenter.ui.components.ComponentButton
import br.com.confchat.auth.presenter.ui.components.ComponentDropUpContainer
import br.com.confchat.auth.presenter.ui.components.ComponentTextFieldOutline
import br.com.confchat.auth.presenter.ui.components.ComponentTextFieldOutlinePwd

@Composable
fun ScreenNewPwd(open:Boolean, onNew:(username:String,pwd:String)->Unit, onDismiss:()->Unit) {
    var username by remember {
        mutableStateOf("")
    }
    var pwd by remember {
        mutableStateOf("")
    }
    var comfirPwd by remember {
        mutableStateOf("")
    }
    ComponentDropUpContainer(expanded = open, onDimiss = onDismiss) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Adicionar dados de autenticacao")
                IconButton(onClick = onDismiss) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 16.dp)
            ) {

                ComponentTextFieldOutline(
                    label = "Username",
                    value = username,
                    onValue = {username = it},
                    modifier = Modifier.fillMaxWidth(),
                    beforeIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                )
                ComponentTextFieldOutlinePwd(
                    label = "Password",
                    value = pwd,
                    onValue = {pwd = it},
                    modifier = Modifier.fillMaxWidth()
                )
                ComponentTextFieldOutlinePwd(
                    label = "Comfir password",
                    value = comfirPwd,
                    onValue = {comfirPwd = it},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(32.dp))
                ComponentButton(
                    enabled = username.isNotBlank() && pwd.isNotBlank() && pwd.equals(comfirPwd),
                    text = "Adicionar"
                ) {
                    onDismiss()
                    onNew(username,pwd)
                }
            }
        }
    }
}

@Preview
@Composable
private fun ScreenNewPwdPreviw() {
    ScreenNewPwd(true,{u,p-> },{})
}