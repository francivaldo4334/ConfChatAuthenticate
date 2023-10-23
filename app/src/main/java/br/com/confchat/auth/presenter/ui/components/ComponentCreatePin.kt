package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComponentCreatePin(onClick:(String)->Unit) {
    var pin by remember{
        mutableStateOf("")
    }
    var confirmPin by remember {
        mutableStateOf("")
    }
    LazyColumn(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        item{
            Text(text = "Adicione uma Senha", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Digite uma senha de oito numeros para criptografar seus dados com intuito de restringir o acesso de outras pessoas a suas senhas.", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(16.dp))
            ComponentTextFieldOutlinePwd(
                keyType = KeyboardType.Number,
                value = pin,
                onValue = {
                if(it.length <= 8)
                    pin = it
            })
            Spacer(modifier = Modifier.height(16.dp))
            ComponentTextFieldOutlinePwd(
                keyType = KeyboardType.Number,
                value = confirmPin,
                onValue = {
                if(it.length <= 8)
                    confirmPin = it
            })
        }
        item {
            ComponentButton(
                text = "Confimar",
                enabled = pin.isNotBlank() && pin.length == 8 && confirmPin.equals(pin)
            ) {
                onClick(pin)
            }
        }
    }
}

@Preview
@Composable
fun ComponentCreatePinPreview() {
    ComponentCreatePin(){}
}