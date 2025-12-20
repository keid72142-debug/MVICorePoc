package com.example.mvicorepoc.presentation.auth.login

import com.example.mvicorepoc.presentation.auth.login.LoginFeature.Wish.Login

class LoginEventTransformer {

    operator fun invoke(event: LoginEvents): LoginFeature.Wish = when (event) {
        is LoginEvents.LoginButtonClicked -> Login(event.email, event.password)

    }
}