package br.com.confchat.auth.presenter.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.confchat.auth.R
import br.com.confchat.mobile.presenter.view.constants.Route

@Composable
fun ComponentNavigate(
    listTypeRow: Boolean,
    onIsGrid: (Boolean) -> Unit,
    navController: NavController,
    horizontalBias: Float,
    onHorizontalBias: (Float) -> Unit,
    page:String,
    onPage:(String)->Unit
) {
    var openMenu by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
                .height(72.dp)
                .padding(vertical = 16.dp)
                .padding(start = 12.dp, end = 4.dp)
                .align(Alignment.TopCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_confchat),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(R.string.autenticador),
                modifier = Modifier.weight(1f),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            AnimatedVisibility(
                visible = page.equals(Route.Tokens),
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                ComponentSwithIcons(
                    checked = listTypeRow,
                    horizontalBias = horizontalBias,
                    onHorizontalBias = onHorizontalBias
                ){
                    onIsGrid(it)
                }
            }
            IconButton(onClick = { openMenu = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = null
                )
                DropdownMenu(expanded = openMenu, onDismissRequest = { openMenu = false }) {
                    DropdownMenuItem(
                        leadingIcon = {
                            Icon(painterResource(id = R.drawable.ic_qr_code_scanner), contentDescription = null,tint = MaterialTheme.colorScheme.onBackground)
                        },
                        text = {
                            Text(text = stringResource(R.string.autorizr_dispositivo),modifier = Modifier.padding(end = 32.dp))
                        },
                        onClick = { /*TODO*/ }
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val pageItem : @Composable (String,String)->Unit = {pageItem,text->
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable {
                            navController.navigate(pageItem) {
                                popUpTo(pageItem) {
                                    inclusive = true
                                }
                            }
                            onPage(pageItem)
                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val animationColor by animateColorAsState(
                        targetValue =
                            if(page.equals(pageItem))
                                MaterialTheme.colorScheme.onBackground
                            else
                                MaterialTheme.colorScheme.onBackground.copy(0.5f),
                        label = ""
                    )
                    Text(
                        text = text,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = animationColor
                    )
                    AnimatedVisibility(
                        visible = page.equals(pageItem),
                        enter = expandVertically(),
                        exit = shrinkVertically()
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(animationColor)
                        )
                    }
                }
            }
            pageItem(Route.Tokens,"Tokens")
            pageItem(Route.Passwords,"Senhas")
        }
    }
}

@Preview
@Composable
fun ComponentNavigateBottomPreview() {
    ComponentNavigate(false,{}, rememberNavController(),0f,{},""){}
}