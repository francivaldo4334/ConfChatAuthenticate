package br.com.confchat.auth.presenter.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

typealias ItemOffset = Animatable<DpOffset, AnimationVector2D>

fun ItemOffset(offset: DpOffset): ItemOffset = Animatable(offset, DpOffset.VectorConverter)
@Composable
fun <ITEM> AnimatedVerticalGrid(
    items: List<ITEM>,
    columns: Int,
    height: Dp? = null,
    modifier: Modifier = Modifier,
    animationSpec: AnimationSpec<DpOffset> = tween(1000),
    itemContent: @Composable (BoxScope.(ITEM) -> Unit),
) = BoxWithConstraints(modifier) {
    val rows = (items.size/columns)+1
    val itemSize = remember(columns) {
        val itemWidth = (maxWidth) / columns
        DpSize(itemWidth, height?:itemWidth)
    }
    val gridOffsets = remember(rows,columns) {
        (0 until rows).map { y ->
            (0 until columns).map { x ->
                DpOffset(
                    x = itemSize.width * x,
                    y = itemSize.height * y,
                )
            }
        }.flatten()
    }
    val itemContent = items.mapIndexed { index, item ->
        val offset = Offset(0f,0f)
    }
    items.forEachIndexed{index, item ->
        val offset = gridOffsets.get(index)
        Box(
            modifier = Modifier
                .size(itemSize)
                .offset(offset.x,offset.y)
        ) {
            items.forEach {
                itemContent(it)
            }
        }
    }

//    LaunchedEffect(Unit) {
//        items.forEachIndexed { index, item ->
//            val newOffset = gridOffsets[index]
//            val itemOffset = itemsOffsets.getValue(itemKey(item))
//            launch { newOffset.animateTo(newOffset, animationSpec) }
//        }
//    }
}