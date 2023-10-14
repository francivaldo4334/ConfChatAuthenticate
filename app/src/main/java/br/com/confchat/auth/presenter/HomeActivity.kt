package br.com.confchat.auth.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.confchat.auth.presenter.ui.components.ComponentDialogPin
import br.com.confchat.auth.presenter.ui.components.ComponentNavigate
import br.com.confchat.auth.presenter.ui.screens.ScreenPasswords
import br.com.confchat.auth.presenter.ui.screens.ScreenTokens
import br.com.confchat.auth.presenter.ui.theme.ConfChatAuthTheme
import br.com.confchat.mobile.presenter.view.constants.Route

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ConfChatAuthTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var navController = rememberNavController()
                    val density = LocalDensity.current
                    var isGrid by remember { mutableStateOf(false) }
                    var columns by rememberSaveable { mutableStateOf(1) }
                    var horizontalBias by remember { mutableStateOf(-1f) }
                    var page by remember { mutableStateOf(Route.Tokens) }
                    var openInsertPin by remember{ mutableStateOf(false) }
                    NavHost(
                        navController = navController,
                        startDestination = Route.Tokens,
                        modifier = Modifier
                            .padding(
                                top = with(density){
                                    WindowInsets.statusBars.getTop(density).toDp() + 72.dp
                                },
                                bottom = 56.dp
                            )
                    ){
                        composable(Route.Tokens){
                            ScreenTokens(isGrid,columns)
                        }
                        composable(Route.Passwords){
                            ScreenPasswords()
                        }
                    }
                    ComponentNavigate(
                        listTypeRow = isGrid,
                        onIsGrid = {
                            isGrid = !isGrid
                            if(isGrid){
                                columns = 3
                            }
                            else{
                                columns = 1
                            }
                        },
                        navController = navController,
                        horizontalBias = horizontalBias,
                        onHorizontalBias = {
                            horizontalBias = it
                        },
                        page = page,
                        onPage = {
                            page = it
                        }
                    )
                    if(openInsertPin){
                        ComponentDialogPin(){
                            openInsertPin = false
                        }
                    }
                    LaunchedEffect(key1 = Unit, block = {
                        openInsertPin = true
                    })
                }
            }
        }
    }
}