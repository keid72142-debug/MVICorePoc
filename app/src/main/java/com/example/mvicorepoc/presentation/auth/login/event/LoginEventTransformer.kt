package com.example.mvicorepoc.presentation.auth.login.event

import com.example.mvicorepoc.presentation.auth.login.LoginFeature
import com.example.mvicorepoc.presentation.auth.login.LoginFeature.Wish.Login
import javax.inject.Inject

class LoginEventTransformer @Inject constructor() {

    operator fun invoke(event: LoginEvents): LoginFeature.Wish = when (event) {
        is LoginEvents.LoginButtonClicked -> Login(event.email, event.password)
        LoginEvents.SignUpButtonClicked -> LoginFeature.Wish.NavigateToSignupScreen

    }
}