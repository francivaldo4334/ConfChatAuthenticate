package br.com.confchat.auth.presenter.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ComponentDropUpContainer(
    expanded:Boolean,
    onDimiss:()->Unit,
    container: @Composable ()->Unit
) {
    AnimatedVisibility(
        visible = expanded,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            Box(modifier = Modifier
                .fillMaxSize()
                .clickable { onDimiss() }
                .background(MaterialTheme.colorScheme.onBackground.copy(0.2f)))
            Box(modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .background(MaterialTheme.colorScheme.background)
            ){
                container()
            }
        }
    }
}