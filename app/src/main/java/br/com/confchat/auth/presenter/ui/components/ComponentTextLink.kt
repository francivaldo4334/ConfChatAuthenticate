package br.com.confchat.auth.presenter.ui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.confchat.auth.presenter.ui.theme.ConfChatAuthTheme

@Composable
fun ComponentTextLink1(textLeft:String = "",textRight:String = "",onClick:()->Unit) {
    var text = buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = 14.sp),){
            append(textLeft)
        }
        withStyle(style = SpanStyle(fontSize = 16.sp,color = MaterialTheme.colorScheme.onSurfaceVariant)){
            pushStringAnnotation(textRight,textRight)
            append(textRight)
        }
    }
    ClickableText(text = text, onClick = {
        text.getStringAnnotations(textRight,it,it).firstOrNull()?.let {
            onClick()
        }
    })
}

@Preview
@Composable
private fun ComponentTextLink1Preview() {
    ConfChatAuthTheme {
        ComponentTextLink1(){}
    }
}