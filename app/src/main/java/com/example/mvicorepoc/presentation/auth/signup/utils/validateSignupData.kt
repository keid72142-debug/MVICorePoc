package com.example.mvicorepoc.presentation.auth.signup.utils

import com.example.mvicorepoc.presentation.auth.signup.component.ExecutionResult

private fun validateFullName(fullName: String): ExecutionResult? {
    val trimmedFullName = fullName.trim()

    return when {
        trimmedFullName.isEmpty() ->
            ExecutionResult.FullNameEmpty

        else -> null
    }
}

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

private fun validateBirthDate(birthDate: String): ExecutionResult? {
    val trimmedBirthDate = birthDate.trim()

    return when {
        trimmedBirthDate.isEmpty() ->
            ExecutionResult.BirthDateEmpty

        !isDateValid(trimmedBirthDate) ->
            ExecutionResult.InvalidBirthDate

        else -> null
    }
}

private fun validatePhoneNumber(phoneNumber: String): ExecutionResult? {
    val trimmedPhoneNumber = phoneNumber.trim()

    return when {
        trimmedPhoneNumber.isEmpty() ->
            ExecutionResult.PhoneNumberEmpty

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

fun validateSignupData(
    fullName: String,
    email: String,
    birthDate: String,
    phoneNumber: String,
    password: String
): ExecutionResult {

    validateFullName(fullName)?.let { return it }
    validateEmail(email)?.let { return it }
    validateBirthDate(birthDate)?.let { return it }
    validatePhoneNumber(phoneNumber)?.let { return it }
    validatePassword(password)?.let { return it }

    return ExecutionResult.ValidSignupData
}

private fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

