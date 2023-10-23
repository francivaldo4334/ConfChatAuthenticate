package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.confchat.auth.R

@Composable
fun ComponentTextFieldOutlinePwd(
    value:String,
    label:String = "",
    keyType:KeyboardType = KeyboardType.Text,
    modifier: Modifier = Modifier,
    onValue:(String)->Unit
) {
    var visible by remember {
        mutableStateOf(false)
    }
    ComponentTextFieldOutline(
        value = value,
        onValue = onValue,
        modifier = modifier,
        label = label,
        keyType = keyType,
        visualTransfortion = if(visible) VisualTransformation.None else PasswordVisualTransformation(),
        beforeIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_key),
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)
            )
        },
        afterIcon = {
            IconButton(onClick = { visible = !visible }) {
                Icon(
                    painter = painterResource(id = if(visible) R.drawable.ic_visibility_off else R.drawable.ic_visibility),
                    contentDescription = null
                )
            }
        }
    )
}

@Preview
@Composable
fun ComponentTextFieldOutlinePwdPreview() {
    ComponentTextFieldOutlinePwd(""){

    }
}