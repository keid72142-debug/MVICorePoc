package com.example.mvicorepoc.presentation.auth.login.event


sealed class LoginEvents {
    data class LoginButtonClicked(val email: String, val password: String) : LoginEvents()
    object SignUpButtonClicked : LoginEvents()
}