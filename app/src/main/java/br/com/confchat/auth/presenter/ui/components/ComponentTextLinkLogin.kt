package br.com.confchat.mobile.presenter.view.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.confchat.auth.R
import br.com.confchat.auth.presenter.ui.components.ComponentTextLink1

@Composable
fun ComponentTextLinkLogin(onClick: () -> Unit) {
    ComponentTextLink1(
        textLeft = stringResource(R.string.ja_tem_uma_conta),
        textRight = stringResource(R.string.entrar),
        onClick = onClick
    )
}

@Preview
@Composable
private fun ComponentTextLinkLoginPreview() {
    ComponentTextLinkLogin {

    }
}