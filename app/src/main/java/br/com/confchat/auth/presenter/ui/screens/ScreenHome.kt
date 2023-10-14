package br.com.confchat.auth.presenter.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.confchat.auth.R
import br.com.confchat.auth.presenter.ui.components.ComponentTotpItem
import br.com.confchat.auth.presenter.ui.theme.ConfChatAuthTheme
import br.com.confchat.auth.presenter.viewmodel.model.TotpItem

@Composable
fun ScreenTokens(isGrid:Boolean, columns:Int) {
    val listTotpItem : List<TotpItem> = buildList {
        add(TotpItem("teste","teste","XXX XXX",0.5f,0))
        add(TotpItem("teste","teste","XXX XXX",0.5f,1))
        add(TotpItem("teste","teste","XXX XXX",0.5f,2))
    }
    val context = LocalContext.current
    val copyedText = stringResource(R.string.codigo_copiado)
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val width =
        if(isGrid)
            maxWidth/4
        else
            maxWidth
        LazyVerticalGrid(
            columns = GridCells.Adaptive(width),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ){
            items(listTotpItem){
                ComponentTotpItem(it = it,isGrid = isGrid){
                    Toast.makeText(context, copyedText, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

@Preview
@Composable
private fun ScreenTokensPreview() {
    ConfChatAuthTheme {
        ScreenTokens(false,1)
    }
}