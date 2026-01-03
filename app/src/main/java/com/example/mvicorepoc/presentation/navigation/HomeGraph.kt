package com.example.mvicorepoc.presentation.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.mvicorepoc.presentation.home.ui.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeGraph : NavKey {
    @Serializable
    object Home : NavKey
}

fun EntryProviderScope<NavKey>.homeRoute() {
    entry<HomeGraph.Home> {
        HomeScreen()
    }
}