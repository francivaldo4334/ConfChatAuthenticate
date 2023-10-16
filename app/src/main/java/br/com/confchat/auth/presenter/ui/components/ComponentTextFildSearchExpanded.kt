package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ComponentTextFildSearchExpanded(
    expanded:Boolean,
    value:String,
    onValue: (String)->Unit
) {
    BasicTextField(
        value = value,
        onValueChange = onValue
    )
}

@Preview
@Composable
fun ComponentTextFildSearchExpandedPreview() {
    ComponentTextFildSearchExpanded(true,"",{})
}