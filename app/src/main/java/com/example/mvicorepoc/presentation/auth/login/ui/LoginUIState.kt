package com.example.mvicorepoc.presentation.auth.login.ui


data class LoginUIState(
    val isLoading: Boolean = false,
    val emailError: Int? = null,
    val passwordError: Int? = null,
)