package com.example.mvicorepoc.presentation.auth.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import kotlinx.coroutines.launch

fun Modifier.shake(
    enabled: Boolean,
    shakeDistance: Float = 20f,
): Modifier = composed {

    val offset = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(enabled) {
        if (enabled) {
            scope.launch {
                offset.snapTo(0f)
                offset.animateTo(-shakeDistance, tween(50))
                offset.animateTo(shakeDistance, tween(50))
                offset.animateTo(-shakeDistance / 2, tween(50))
                offset.animateTo(0f, tween(50))
            }
        }
    }

    graphicsLayer {
        translationX = offset.value
    }
}
