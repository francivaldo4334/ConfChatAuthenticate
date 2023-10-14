package br.com.confchat.mobile.presenter.view.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.confchat.auth.R
import br.com.confchat.auth.presenter.ui.components.ComponentTextLink1

@Composable
fun ComponentTextLinkLogout(onClick: () -> Unit) {
    ComponentTextLink1(
        textLeft = stringResource(R.string.nao_tem_uma_conta),
        textRight = stringResource(R.string.criar_conta),
        onClick = onClick
    )
}

@Preview
@Composable
private fun ComponentTextLinkLogoutPreview() {
    ComponentTextLinkLogout {

    }
}