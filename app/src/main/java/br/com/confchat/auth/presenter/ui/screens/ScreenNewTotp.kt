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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import br.com.confchat.auth.presenter.ui.components.ComponentDropUpContainer
import br.com.confchat.auth.presenter.ui.components.ComponentTextFieldOutline
import br.com.confchat.auth.presenter.ui.components.ComponentTextFieldOutlinePwd

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenNewTotp(open:Boolean, onDismiss:()->Unit) {
    var issuer by remember {
        mutableStateOf("")
    }
    var accountName by remember {
        mutableStateOf("")
    }
    var secretKey by remember {
        mutableStateOf("")
    }
    ComponentDropUpContainer(expanded = open, onDimiss = onDismiss) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
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
            ComponentTextFieldOutline(
                label = "Issuer (opcional)",
                value = issuer,
                onValue = {issuer = it},
                modifier = Modifier.fillMaxWidth()
            )
            ComponentTextFieldOutline(
                label = "Account name",
                value = accountName,
                onValue = {accountName = it},
                modifier = Modifier.fillMaxWidth()
            )
            ComponentTextFieldOutlinePwd(
                label = "Secret key",
                value = secretKey,
                onValue = {secretKey = it},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(72.dp))
        }
    }
}

@Preview
@Composable
private fun ScreenNewTotpPreview() {
    ScreenNewTotp(true){}
}