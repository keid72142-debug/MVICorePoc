package com.example.mvicorepoc.presentation.auth.login


sealed class LoginEvents {
    data class LoginButtonClicked(val email: String, val password: String) : LoginEvents()
//    data class SignUpButtonClicked(val email: String, val password: String) : LoginEvents()
//    object ContinueWithGoogleButtonClicked : LoginEvents()
//    object ContinueWithFacebookButtonClicked : LoginEvents()
}