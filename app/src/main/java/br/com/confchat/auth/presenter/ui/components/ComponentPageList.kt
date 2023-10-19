package br.com.confchat.auth.presenter.ui.components

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.confchat.auth.presenter.ui.screens.ScreenListPwd
import br.com.confchat.auth.presenter.ui.screens.ScreenListTopt
import br.com.confchat.auth.presenter.viewmodel.model.PwdItem
import br.com.confchat.auth.presenter.viewmodel.model.TotpItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComponentPageList(search:String,listTotp:List<TotpItem>,listPwd:List<PwdItem>) {
    val state = rememberLazyListState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val boll: @Composable (Boolean)->Unit = {
            Box(modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(
                    if (it) {
                        MaterialTheme.colorScheme.onBackground
                    } else {
                        MaterialTheme.colorScheme.onBackground.copy(0.5f)
                    }
                ))
        }
        Row {
            boll(state.firstVisibleItemIndex.equals(0))
            Spacer(modifier = Modifier.width(16.dp))
            boll(state.firstVisibleItemIndex.equals(1))
        }
        Spacer(modifier = Modifier.height(32.dp))
        //LIST PAGE
        LazyRow(
            modifier = Modifier
                .fillMaxSize(),
            state = state,
            flingBehavior = rememberSnapFlingBehavior(lazyListState = state)
        ) {
            item {
                ScreenListTopt(listTotp.filter { if(search.isNotBlank()) it.appName.contains(search) else true })
            }
            item {
                ScreenListPwd(listPwd.filter { if(search.isNotBlank()) it.site.contains(search) else true })
            }
        }
    }
}

@Preview
@Composable
private fun ComponentPageListPreview() {
    ComponentPageList("",emptyList(), emptyList())
}