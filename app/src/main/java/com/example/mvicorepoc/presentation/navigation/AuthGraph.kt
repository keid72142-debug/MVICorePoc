package com.example.mvicorepoc.presentation.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.mvicorepoc.presentation.auth.login.ui.LoginScreen
import com.example.mvicorepoc.presentation.auth.signup.SignupScreen
import kotlinx.serialization.Serializable

@Serializable
class AuthGraph : NavKey {
    @Serializable
    object Login : NavKey


    @Serializable
    object Signup : NavKey
}


fun EntryProviderScope<NavKey>.authRoute(navController: Navigator) {
    entry<AuthGraph.Login> {
        LoginScreen(
            onNavigateToHome = {
                navController.navigate(HomeGraph.Home)
            },
            onNavigateToSignup = {
                navController.navigate(AuthGraph.Signup)
            }
        )
    }
    entry<AuthGraph.Signup> {
        SignupScreen(
            onNavigateToHome = {
                navController.navigate(HomeGraph.Home)
            },
            onNavigateToLogin = {
                navController.navigate(AuthGraph.Login)
            }
        )
    }
}
