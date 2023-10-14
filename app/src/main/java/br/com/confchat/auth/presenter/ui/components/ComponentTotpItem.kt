package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.confchat.auth.R
import br.com.confchat.auth.presenter.viewmodel.model.TotpItem

@Composable
fun ComponentTotpItem(it: TotpItem, isGrid:Boolean, onClick:()->Unit) {
    val modifier =
        if(isGrid)
            Modifier
            .clickable {
                onClick()
            }
            .fillMaxWidth()
            .aspectRatio(1f)

        else Modifier
            .fillMaxWidth()
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
                shape = RoundedCornerShape(8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(12.dp)
                .size(56.dp),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator(
                modifier = Modifier
                    .size(56.dp),
                progress = it.progress,
                strokeWidth = 2.dp
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_confchat),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }
        if(!isGrid) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                val appAndUser = buildAnnotatedString {
                    val appName = it.appName
                    val user = it.userName
                    append(appName)
                    if (user.isNotBlank()) {
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
                                fontWeight = FontWeight.SemiBold
                            )
                        ) {
                            append(" (${user})")
                        }
                    }
                }
                Text(text = appAndUser, fontSize = 10.sp)
                Text(text = "XXX XXX", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            }
            IconButton(
                onClick = {
                    onClick()
                },
                modifier = Modifier.size(56.dp)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_copy), contentDescription = null)
            }
        }
    }
}