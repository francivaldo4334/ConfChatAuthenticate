package br.com.confchat.auth.presenter.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.confchat.auth.presenter.ui.components.ComponentItemPwd
import br.com.confchat.auth.presenter.viewmodel.model.PwdItem

@Composable
fun ScreenListPwd(list:List<PwdItem>) {
    val conf = LocalConfiguration.current
    val h = conf.screenHeightDp
    val w = conf.screenWidthDp
    LazyColumn(
        modifier = Modifier
            .width(w.dp)
            .height(h.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(list){
            ComponentItemPwd(it)
        }
    }
}

@Preview
@Composable
private fun ScreenListPwdPreview() {
    ScreenListPwd(emptyList())
}