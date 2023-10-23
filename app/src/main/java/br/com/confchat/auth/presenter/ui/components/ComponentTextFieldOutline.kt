package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentTextFieldOutline(
    value:String,
    label:String = "",
    modifier:Modifier = Modifier,
    visualTransfortion: VisualTransformation = VisualTransformation.None,
    keyType:KeyboardType = KeyboardType.Text,
    beforeIcon: @Composable ()->Unit = {},
    afterIcon: @Composable ()->Unit = {},
    onValue:(String)->Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if(label.isNotBlank()){
            Text(text = label, fontSize = 12.sp)
        }
        BasicTextField(
            keyboardOptions = KeyboardOptions(keyboardType = keyType),
            visualTransformation = visualTransfortion,
            singleLine = true,
            modifier = Modifier.border(
                1.dp,
                MaterialTheme.colorScheme.onBackground,
                RoundedCornerShape(8.dp)
            ),
            value = value,
            onValueChange = onValue,
            decorationBox = {
                Box(
                    modifier = modifier
                        .height(56.dp)
                        .padding(horizontal = 12.dp),
                    contentAlignment = Alignment.CenterStart
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = modifier
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            beforeIcon()
                            it()
                        }
                        afterIcon()
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun ComponentTextFieldOutlinePreview() {
    ComponentTextFieldOutline(""){}
}