package br.com.confchat.auth.presenter.ui.screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.confchat.auth.R
import br.com.confchat.auth.presenter.viewmodel.model.PwdItem

@Composable
fun ScreenPasswords() {
    val listPwdItem:List<PwdItem> = buildList {
        add(PwdItem("user@gmail.com","1234","site.com.br"))
        add(PwdItem("user@gmail.com","1234","site.com.br"))
        add(PwdItem("user@gmail.com","1234","site.com.br"))
        add(PwdItem("user@gmail.com","1234","site.com.br"))
    }
    val context = LocalContext.current
    val user_cp = stringResource(R.string.usuario_copiado)
    val pwd_cp = stringResource(R.string.senha_copiada)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(listPwdItem){
            var openMenu by remember{ mutableStateOf(false) }
            var visiblePwd by remember { mutableStateOf(false) }
            Column(
                modifier = Modifier
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.onBackground.copy(0.5f),
                        RoundedCornerShape(8.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_confchat),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(40.dp)
                    )
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = it.site,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = it.userName,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    IconButton(onClick = { openMenu = !openMenu }) {
                        Icon(
                            imageVector = if(openMenu) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = null
                        )
                    }
                }
                AnimatedVisibility(
                    visible = openMenu,
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 12.dp, start = 12.dp, end = 12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(text = stringResource(id = R.string.nome_de_usuario), fontSize = 12.sp)
                                Text(text = it.userName, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                            }
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable {
                                        /*TODO*/
                                        Toast
                                            .makeText(
                                                context,
                                                user_cp,
                                                Toast.LENGTH_LONG
                                            )
                                            .show()
                                    }
                                    .background(MaterialTheme.colorScheme.onBackground)
                                    .padding(8.dp)
                            ){
                                Text(text = stringResource(R.string.copiar),color = MaterialTheme.colorScheme.background, fontSize = 12.sp,softWrap = false)
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(text = stringResource(id = R.string.senha), fontSize = 12.sp)
                                Text(text =
                                if(visiblePwd)
                                    it.password
                                else
                                    "*".repeat(it.password.length),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    softWrap = false
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(onClick = { visiblePwd = !visiblePwd }) {
                                    Icon(painter = painterResource(id = if(visiblePwd) R.drawable.ic_visibility_off else R.drawable.ic_visibility), contentDescription = null)
                                }
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(8.dp))
                                        .clickable {
                                            /*TODO*/
                                            Toast
                                                .makeText(
                                                    context,
                                                    pwd_cp,
                                                    Toast.LENGTH_LONG
                                                )
                                                .show()
                                        }
                                        .background(MaterialTheme.colorScheme.onBackground)
                                        .padding(8.dp)
                                ){
                                    Text(text = stringResource(R.string.copiar),color = MaterialTheme.colorScheme.background, fontSize = 12.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ScreenPasswordsPreview() {
    ScreenPasswords()
}