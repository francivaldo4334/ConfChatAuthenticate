package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Composable
fun RowScope.ComponentTextFildSearchExpanded(
    expanded:Boolean,
    value:String,
    onValue: (String)->Unit,
) {
    BasicTextField(
        value = value,
        onValueChange = onValue,
        modifier =
            if(expanded)
                Modifier.weight(1f).padding(start = 8.dp)
            else
                Modifier,
        decorationBox = {
            Row(
                Modifier
                    .border(
                            1.dp, MaterialTheme.colorScheme.onBackground,
                    CircleShape
                    )
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
                Box(modifier =
                    if(expanded)
                        Modifier
                    else
                        Modifier.width(0.dp)
                ){
                    it()
                }
            }
        }
    )
}

@Preview
@Composable
fun ComponentTextFildSearchExpandedPreview() {
    Row{
        ComponentTextFildSearchExpanded(false,"",{})
    }
}