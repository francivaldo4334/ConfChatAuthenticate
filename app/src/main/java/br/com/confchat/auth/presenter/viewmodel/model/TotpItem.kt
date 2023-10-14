package br.com.confchat.auth.presenter.viewmodel.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

data class TotpItem(
    val appName:String,
    val userName:String,
    val code:String,
    val progress:Float,
    val id:Int
)