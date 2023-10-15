package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.confchat.auth.R
import br.com.confchat.auth.presenter.viewmodel.model.TotpItem

@Composable
fun ComponentTop() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ){
        Icon(
            painter = painterResource(id = R.drawable.vector_1_),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center),
            tint = Color(0xFF5E964B)
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 20.dp)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .border(
                            1.dp, MaterialTheme.colorScheme.onBackground,
                            CircleShape
                        )
                        .padding(4.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(90f)
                        .border(
                            1.dp, MaterialTheme.colorScheme.onBackground,
                            CircleShape
                        )
                        .padding(4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ComponentTopPreview() {
    ComponentTop()
}