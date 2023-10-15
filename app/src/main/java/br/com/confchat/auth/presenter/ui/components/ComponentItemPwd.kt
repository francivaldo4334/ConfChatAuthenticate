package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.confchat.auth.R
import br.com.confchat.auth.presenter.viewmodel.model.PwdItem

@Composable
fun ComponentItemPwd(it:PwdItem) {
    var openMenuInforms by remember {
        mutableStateOf(false)
    }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ComponentImagePreview(it.site)
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = it.site, fontSize = 12.sp,color = MaterialTheme.colorScheme.onBackground, fontWeight = FontWeight.Bold)
                Text(text = it.userName, fontSize = 12.sp,color = MaterialTheme.colorScheme.onBackground)
            }
            IconButton(onClick = { openMenuInforms = !openMenuInforms }) {
                if(openMenuInforms){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_drop_up),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
                else{
                    Icon(
                        painter = painterResource(id = R.drawable.ic_drop_down),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
        //DROP DOWN MENU
        ComponentDropMenuPwd(openMenuInforms,it.userName,it.password)
    }
}

@Preview
@Composable
private fun ComponentItemPwdPreview() {
    ComponentItemPwd(PwdItem("Teste","1244","site.com.br"))
}