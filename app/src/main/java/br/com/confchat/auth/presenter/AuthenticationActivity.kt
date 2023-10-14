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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.confchat.auth.presenter.ui.screens.ResetePasswordScreen
import br.com.confchat.auth.presenter.ui.screens.ScreenLogin
import br.com.confchat.auth.presenter.ui.screens.ScreenLogup
import br.com.confchat.auth.presenter.ui.screens.SendResetePasswordScreen
import br.com.confchat.auth.presenter.ui.theme.ConfChatAuthTheme
import br.com.confchat.mobile.presenter.view.constants.Route

class AuthenticationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConfChatAuthTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var navController = rememberNavController()
                    val density = LocalDensity.current
                    NavHost(
                        navController = navController,
                        startDestination = Route.Login,
                        modifier = Modifier.padding(top = with(density){
                            WindowInsets.statusBars.getTop(density).toDp()
                        } )
                    ){
                        composable(Route.Login){
                            ScreenLogin(navController)
                        }
                        composable(Route.Logup){
                            ScreenLogup(navController)
                        }
                        composable(Route.SendResetePasssword){
                            SendResetePasswordScreen(navController)
                        }
                        composable(Route.ResetePasssword){
                            ResetePasswordScreen(navController)
                        }
                    }
                }
            }
        }
    }
}