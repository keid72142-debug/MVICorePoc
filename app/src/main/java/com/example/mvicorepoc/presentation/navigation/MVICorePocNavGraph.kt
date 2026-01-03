package com.example.mvicorepoc.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.scene.DialogSceneStrategy
import androidx.navigation3.ui.NavDisplay

@Composable
fun MVICorePocNavGraph(
    modifier: Modifier,
) {
    val navigationState = rememberNavigationState(
        startRoute = AuthGraph.Login,
        topLevelRoutes = setOf(AuthGraph.Login, AuthGraph.Signup, HomeGraph.Home)
    )
    val navigator = remember { Navigator(navigationState) }

    val entryProvider = entryProvider {
        authRoute(navigator)
        homeRoute()
    }


    NavDisplay(
        modifier = modifier,
        entries = navigationState.toEntries(entryProvider),
        onBack = { navigator.goBack() },
        sceneStrategy = remember { DialogSceneStrategy() }
    )
}