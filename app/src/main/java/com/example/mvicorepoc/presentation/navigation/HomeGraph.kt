package com.example.mvicorepoc.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.mvicorepoc.presentation.home.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeGraph

fun NavGraphBuilder.homeRoute() {
    composable<HomeGraph> {
        HomeScreen()
    }
}