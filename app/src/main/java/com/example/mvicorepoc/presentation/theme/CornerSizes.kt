package com.example.mvicorepoc.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


data class CornerSizes(
    val r4: Dp = 4.dp,
    val r8: Dp = 8.dp,
    val r12: Dp = 12.dp,
    val r16: Dp = 16.dp,

    )

val LocalCornerSizes = compositionLocalOf { CornerSizes() }

val MaterialTheme.cornerSizes: CornerSizes
    @Composable
    get() = LocalCornerSizes.current
