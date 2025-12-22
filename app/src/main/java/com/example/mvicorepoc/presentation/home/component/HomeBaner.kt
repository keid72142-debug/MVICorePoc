package com.example.mvicorepoc.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun HomeBanner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.medium
            )
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Welcome to Home Screen",
            color = MaterialTheme.colorScheme.primaryContainer,
            style = MaterialTheme.typography.titleLarge,
        )

    }
}