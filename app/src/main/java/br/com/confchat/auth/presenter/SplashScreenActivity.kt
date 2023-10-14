package br.com.confchat.auth.presenter

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import br.com.confchat.auth.presenter.ui.screens.SplashScreen
import br.com.confchat.auth.presenter.ui.theme.ConfChatAuthTheme
import kotlinx.coroutines.delay

class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchedEffect(key1 = Unit, block = {
                delay(2000)
//                viewModel.checkLogin(){
//                    if(it){
//                        startActivity(Intent(this@SplashScreenActivity, HomeActivity::class.java))
//                        finish()
//                    }
//                    else{
                        startActivity(Intent(this@SplashScreenActivity, AuthenticationActivity::class.java))
                        finish()
//                    }
//                }
            })
            ConfChatAuthTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen()
                }
            }
        }
    }
}