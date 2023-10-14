package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComponentDialogPin(onCLick:(pin:String)->Unit) {
    var PIN by remember {
        mutableStateOf("")
    }
    val card: @Composable (Int, String, String) -> Unit = { init, value, default ->
        val gerarStringComPadrao: (String, String) -> String = { prefixo, padrao ->
            val caracteresAleatorios = padrao.substring(prefixo.length)
            "$prefixo$caracteresAleatorios"
        }
        Card(
            shape = RoundedCornerShape(4.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
        ) {
            Text(
                text =
                if (init >= 0 && init < value.length) {
                    val subString = value.substring(
                        init,
                        if (value.length < (init + default.length)) value.length else default.length + init
                    ).toString()
                    gerarStringComPadrao(subString, default)
                } else {
                    default
                },
                modifier = Modifier.padding(4.dp),
                fontSize = 24.sp
            )
        }
    }
    val numberButton: @Composable RowScope.(number: Int) -> Unit = { number ->
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1.8f)
                .clickable {
                    if(PIN.length<8)
                        PIN = PIN+number
                }) {
            Text(
                text = number.toString(),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )
        }
    }
    val deleteButton: @Composable RowScope.() -> Unit = {
        Box(
            modifier = Modifier
                .clickable {
                    if (PIN.length > 0) PIN = (PIN.substring(0, PIN.length - 1))
                }
                .weight(1f)
                .aspectRatio(1.8f)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
    val confirmButton: @Composable RowScope.() -> Unit = {
        Box(
            modifier = Modifier
                .clickable {
                    onCLick(PIN)
                }
                .weight(1f)
                .aspectRatio(1.8f)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.CheckCircle,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
    AlertDialog(
        containerColor = MaterialTheme.colorScheme.background,
        onDismissRequest = { /*TODO*/ },
        confirmButton = {
            Column {
                //TEXTFILD
                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        card(0, PIN, "00")
                        card(2, PIN, "00")
                        card(4, PIN, "00")
                        card(6, PIN, "00")
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                //KEYBOARD
                Row(modifier = Modifier.fillMaxWidth()) {
                    numberButton(1)
                    numberButton(2)
                    numberButton(3)
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    numberButton(4)
                    numberButton(5)
                    numberButton(6)
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    numberButton(7)
                    numberButton(8)
                    numberButton(9)
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    deleteButton()
                    numberButton(0)
                    confirmButton()
                }
            }
        },
    )
}

@Preview
@Composable
fun ComponentDialogPinPreview() {
    ComponentDialogPin(){}
}