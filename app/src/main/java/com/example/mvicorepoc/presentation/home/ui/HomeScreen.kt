package com.example.mvicorepoc.presentation.home.ui

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvicorepoc.presentation.home.component.HomeBanner
import com.example.mvicorepoc.presentation.home.component.ProductItem
import com.example.mvicorepoc.presentation.theme.MVICorePocTheme
import com.example.mvicorepoc.presentation.theme.spacing

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val viewModel: HomeViewModel = hiltViewModel()
    val uiState by viewModel.uiStateFlow.collectAsState()
    HomeContent(
        modifier = modifier,
        homeUiState = uiState
    )
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    homeUiState: HomeUIState
) {
    val context = LocalContext.current
    BackHandler {
        (context as? Activity)?.finish()
    }
    if (homeUiState.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(MaterialTheme.spacing.s8),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.s8)
        ) {
            item {
                HomeBanner(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillParentMaxHeight(0.15f)
                )
            }

            items(
                homeUiState.products, key = { it.id },
            ) {
                ProductItem(product = it)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    MVICorePocTheme {
        HomeContent(
            homeUiState = HomeUIState(
                products = listOf(
                    Product(
                        id = "1",
                        name = "Product 1",
                        description = "Description 1",
                    ),
                    Product(
                        id = "2",
                        name = "Product 1",
                        description = "Description 1",
                    ),
                    Product(
                        id = "3",
                        name = "Product 1",
                        description = "Description 1",
                    ),

                    )
            )
        )
    }
}