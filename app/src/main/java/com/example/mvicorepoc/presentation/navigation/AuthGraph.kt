package com.example.mvicorepoc.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.mvicorepoc.presentation.auth.login.ui.LoginScreen
import com.example.mvicorepoc.presentation.auth.signup.SignupScreen
import kotlinx.serialization.Serializable

@Serializable
class AuthGraph {
    @Serializable
    object Login

    @Serializable
    object Signup
}


fun NavGraphBuilder.authRoute(navController: NavHostController) {

    composable<AuthGraph.Login> {
        LoginScreen(
            onNavigateToHome = {
                navController.navigate(HomeGraph.Home)
            },
            onNavigateToSignup = {
                navController.navigate(AuthGraph.Signup)
            }
        )

    }
    composable<AuthGraph.Signup> {
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
