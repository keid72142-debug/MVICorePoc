package com.example.mvicorepoc.presentation.auth.signup.component

sealed class ExecutionResult {
    object FullNameEmpty : ExecutionResult()
    object EmailEmpty : ExecutionResult()
    object BirthDateEmpty : ExecutionResult()
    object PhoneNumberEmpty : ExecutionResult()
    object PasswordEmpty : ExecutionResult()
    object InvalidEmail : ExecutionResult()
    object InvalidBirthDate : ExecutionResult()
    object PasswordTooShort : ExecutionResult()
    object ValidSignupData : ExecutionResult()

}

