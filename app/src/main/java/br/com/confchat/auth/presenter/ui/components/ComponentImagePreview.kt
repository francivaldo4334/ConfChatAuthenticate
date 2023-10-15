package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import androidx.core.graphics.component3
import br.com.confchat.auth.R
import java.util.Random

@Composable
fun ComponentImagePreview(name:String) {
    val rnd = Random()
    var (r,g,b) = 0
    r = rnd.nextInt(256)
    g = rnd.nextInt(256)
    b = rnd.nextInt(256)
    val color = Color(red = r,green = g,blue = b)
    val onColor = if((r * 0.299 + g * 0.587 + b * 0.114)> 186) Color.Black else Color.White
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name.first().toString().uppercase(), fontSize = 24.sp, fontWeight = FontWeight.Bold,color = onColor)
    }
}