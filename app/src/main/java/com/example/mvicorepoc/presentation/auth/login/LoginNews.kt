package com.example.mvicorepoc.presentation.auth.login

import com.badoo.mvicore.element.NewsPublisher
import com.example.mvicorepoc.presentation.auth.login.LoginFeature.News.NavigateToHomeScreen
import com.example.mvicorepoc.presentation.auth.login.LoginFeature.News.NavigateToSignupScreen
import com.example.mvicorepoc.presentation.auth.login.LoginFeature.News.ShowError

class LoginNews :
    NewsPublisher<LoginFeature.Action, LoginFeature.Effect, LoginFeature.State, LoginFeature.News> {
    override fun invoke(
        action: LoginFeature.Action,
        effect: LoginFeature.Effect,
        state: LoginFeature.State
    ): LoginFeature.News? {
        return when (effect) {
            is LoginFeature.Effect.Loading -> null
            is LoginFeature.Effect.LoginSuccess -> NavigateToHomeScreen
            is LoginFeature.Effect.LoginError -> ShowError(effect.message)
            LoginFeature.Effect.NavigateToSignupScreen -> NavigateToSignupScreen

        }
    }
}