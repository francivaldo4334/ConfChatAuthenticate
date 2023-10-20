package br.com.confchat.auth.presenter.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material.icons.twotone.KeyboardArrowDown
import androidx.compose.material.icons.twotone.KeyboardArrowRight
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import br.com.confchat.auth.R

@Composable
fun ComponentTop(onNewPwd:()->Unit) {
    var expandedMenu by remember{
        mutableStateOf(false)
    }
    val density = LocalDensity.current
    var topBarW by remember {
        mutableStateOf(0)
    }
    var offsetX by remember {
        mutableStateOf(0.dp)
    }
    var expandedSubMenuTotp by remember {
        mutableStateOf(false)
    }
    var expandedSubMenuPwd by remember {
        mutableStateOf(false)
    }
    var submenuH by remember {
        mutableStateOf(0.dp)
    }
    val onDismissAll = {
        expandedMenu = false
        expandedSubMenuTotp = false
        expandedSubMenuPwd = false
    }
    Column(
        modifier = Modifier.onPlaced {
            topBarW = it.size.width
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 16.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.vector_1_),
                contentDescription = null,
                tint = Color(0xFF5E964B),
                modifier = Modifier.align(Alignment.Center)
            )
            IconButton(
                onClick = { expandedMenu = true },
                modifier = Modifier.size(32.dp).align(Alignment.CenterEnd)
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
        DropdownMenu(
            expanded = expandedMenu,
            onDismissRequest = {
                onDismissAll()
            },
            modifier = Modifier
                .onPlaced {
                    offsetX = with(density){
                        (topBarW - it.size.width).toDp()
                    }
                },
            offset = DpOffset(offsetX - 8.dp, 0.dp)
        ) {
            DropdownMenuItem(
                text = { Text(text = "Adicionar TOTP") },
                onClick = { expandedSubMenuTotp = !expandedSubMenuTotp },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.TwoTone.AddCircle,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if(expandedSubMenuTotp) Icons.TwoTone.KeyboardArrowDown else Icons.TwoTone.KeyboardArrowRight ,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            )
            AnimatedVisibility(
                visible = expandedSubMenuTotp,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {

                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .onPlaced {
                            submenuH = with(density) {
                                it.size.height.toDp()
                            }
                        }
                        .drawBehind {
                            drawLine(
                                color = Color.Black,
                                start = Offset(0f, 0f),
                                end = Offset(0f, size.height),
                                strokeWidth = with(density) { 1.dp.toPx() }
                            )
                        }
                ) {
                    Column {
                        DropdownMenuItem(
                            text = { Text(text = "Escanear QR code") },
                            onClick = { onDismissAll();/*TODO*/ },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_qr_code),
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(text = "Manualmente") },
                            onClick = { onDismissAll();/*TODO*/ },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_edit),
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        )
                    }
                }
            }
            DropdownMenuItem(
                text = { Text(text = "Adicionar Credencial") },
                onClick = { expandedSubMenuPwd = !expandedSubMenuPwd },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.TwoTone.AddCircle,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if(expandedSubMenuPwd) Icons.TwoTone.KeyboardArrowDown else Icons.TwoTone.KeyboardArrowRight ,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            )
            AnimatedVisibility(
                visible = expandedSubMenuPwd,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {

                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .onPlaced {
                            submenuH = with(density) {
                                it.size.height.toDp()
                            }
                        }
                        .drawBehind {
                            drawLine(
                                color = Color.Black,
                                start = Offset(0f, 0f),
                                end = Offset(0f, size.height),
                                strokeWidth = with(density) { 1.dp.toPx() }
                            )
                        }
                ) {
                    Column {
                        DropdownMenuItem(
                            text = { Text(text = "Gerar Aleatoriamente") },
                            onClick = { onDismissAll();/*TODO*/ },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_pwd),
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(text = "Manualmente") },
                            onClick = { onDismissAll();onNewPwd() },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_edit),
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ComponentTopPreview() {
    ComponentTop(){}
}