package com.example.mvicorepoc.presentation.auth.signup.event


sealed class SignupEvents {
    data class SignupButtonClicked(
        val fullName: String,
        val email: String,
        val birthDate: String,
        val phoneNumber: String,
        val password: String
    ) : SignupEvents()

    object LoginButtonClicked : SignupEvents()
}

