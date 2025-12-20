package com.example.mvicorepoc.presentation.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvicorepoc.presentation.theme.MVICorePocTheme
import com.example.mvicorepoc.presentation.theme.spacing

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    HomeContent()
}

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    BackHandler {
        (context as? Activity)?.finish()
    }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(MaterialTheme.spacing.s8),
    ) {

    }
}


@Preview
@Composable
private fun HomePreview() {
    MVICorePocTheme {
        HomeContent()
    }
}