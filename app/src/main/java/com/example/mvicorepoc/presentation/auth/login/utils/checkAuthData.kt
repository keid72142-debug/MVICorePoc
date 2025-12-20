package com.example.mvicorepoc.presentation.auth.login.utils

import com.example.mvicorepoc.presentation.auth.login.component.ExecutionResult

private fun validateEmail(email: String): ExecutionResult? {
    val trimmedEmail = email.trim()

    return when {
        trimmedEmail.isEmpty() ->
            ExecutionResult.EmailEmpty

        !isValidEmail(trimmedEmail) ->
            ExecutionResult.InvalidEmail

        else -> null
    }
}

private fun validatePassword(password: String): ExecutionResult? {
    val trimmedPassword = password.trim()

    return when {
        trimmedPassword.isEmpty() ->
            ExecutionResult.PasswordEmpty

        trimmedPassword.length < 6 ->
            ExecutionResult.PasswordTooShort

        else -> null
    }
}

fun validateCredentials(
    email: String,
    password: String
): ExecutionResult {

    validateEmail(email)?.let { return it }
    validatePassword(password)?.let { return it }

    return ExecutionResult.ValidAuthData
}

private fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}