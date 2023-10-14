package br.com.confchat.auth.presenter.ui.components

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.confchat.auth.R
import br.com.confchat.auth.presenter.ui.theme.ConfChatAuthTheme

@SuppressLint("UnrememberedMutableState")
@Composable
private fun animateHorizontalAlignmentAsState(
    targetBiasValue:Float
) : State<BiasAlignment.Horizontal> {
    val bias by animateFloatAsState(targetValue = targetBiasValue, label = "")
    return derivedStateOf { BiasAlignment.Horizontal(bias) }
}

@Composable
fun ComponentSwithIcons(checked:Boolean,horizontalBias:Float,onHorizontalBias:(Float)->Unit,onCheckedChange:(Boolean)->Unit) {
    val alignment by animateHorizontalAlignmentAsState(targetBiasValue = horizontalBias)
    Column(
        modifier = Modifier
            .clickable {
                if (checked)
                    onHorizontalBias(-1f)
                else
                    onHorizontalBias(1f)
                onCheckedChange(checked)
            }
            .height(32.dp)
            .width(56.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(4.dp),
        horizontalAlignment = alignment
    ){
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colorScheme.background)
                .size(24.dp)
        ){
            this@Column.AnimatedVisibility(
                visible = !checked,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_grid_view),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp),
                    tint = MaterialTheme.colorScheme.onBackground.copy(0.5f)
                )
            }

            this@Column.AnimatedVisibility(
                visible = checked,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_row_view),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp),
                    tint = MaterialTheme.colorScheme.onBackground.copy(0.5f)
                )
            }
        }
    }
}

@Preview
@Composable
fun ComponentSwithIconsPreview() {
    ConfChatAuthTheme {
        ComponentSwithIcons(true,0f,{}){}
    }
}