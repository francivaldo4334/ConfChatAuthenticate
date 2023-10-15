package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.confchat.auth.R
import br.com.confchat.auth.presenter.viewmodel.model.TotpItem

@Composable
fun ComponentItemTotp(it: TotpItem) {
    val progressColor = MaterialTheme.colorScheme.surface
    Row(
        modifier = Modifier
            .clickable {

            }
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 32.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        ComponentImagePreview(it.appName)
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = it.appName, fontSize = 12.sp,color = MaterialTheme.colorScheme.onBackground.copy(0.5f))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = it.code, fontSize = 18.sp, fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.onBackground)
                Icon(
                    painter = painterResource(id = R.drawable.ic_copy_min),
                    contentDescription = null,
                    modifier = Modifier.size(12.dp),
                    tint = MaterialTheme.colorScheme.onBackground.copy(0.5f)
                )
            }
        }
        Canvas(modifier = Modifier.size(24.dp)){
            val w = size.width
            val h = size.height
            val path = Path().apply {
                lineTo(w/2,h/2)
                lineTo(w/2,h/2)
                arcTo(
                    rect = Rect(
                        offset = Offset(0f,0f),
                        size = Size(w,h)
                    ),
                    startAngleDegrees = -90f,
                    sweepAngleDegrees = -220f,
                    forceMoveTo = false
                )
                lineTo(w/2,h/2)
                close()
            }
            drawPath(path = path, color = progressColor)
        }
    }
}

@Preview
@Composable
private fun ComponentItemTotpPreview() {
    ComponentItemTotp(TotpItem("teste","teste","000 000",0.4f,1))
}