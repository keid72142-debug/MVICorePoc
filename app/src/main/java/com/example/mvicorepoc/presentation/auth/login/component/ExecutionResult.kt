package com.example.mvicorepoc.presentation.auth.login.component

sealed class ExecutionResult {
    object EmailEmpty : ExecutionResult()
    object PasswordEmpty : ExecutionResult()
    object InvalidEmail : ExecutionResult()
    object PasswordTooShort : ExecutionResult()
    object ValidAuthData : ExecutionResult()

}