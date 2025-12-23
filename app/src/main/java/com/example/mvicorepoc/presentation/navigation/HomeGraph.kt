package com.example.mvicorepoc.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mvicorepoc.presentation.home.ui.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeGraph {
    @Serializable
    object Home
}

fun NavGraphBuilder.homeRoute() {
    composable<HomeGraph.Home> {
        HomeScreen()
    }
}