package br.com.confchat.auth.presenter.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun ComponentTop(openSearch:Boolean,search:String,onSearch:(String)->Unit) {
    val animatedSpace by animateDpAsState(targetValue = if (openSearch) 16.dp else 80.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(end = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(modifier = Modifier.width(animatedSpace))
        Icon(
            painter = painterResource(id = R.drawable.vector_1_),
            contentDescription = null,
            tint = Color(0xFF5E964B)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ComponentTextFildSearchExpanded(
                expanded = openSearch,
                value = search,
                onValue = {
                    onSearch(it)
                }
            )
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.size(40.dp)
            ) {
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
    ComponentTop(true,""){}
}