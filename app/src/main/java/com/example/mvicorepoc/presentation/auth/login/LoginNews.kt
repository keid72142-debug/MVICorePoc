package com.example.mvicorepoc.presentation.auth.login

import com.badoo.mvicore.element.NewsPublisher

class LoginNews :
    NewsPublisher<LoginFeature.Action, LoginFeature.Effect, LoginFeature.State, LoginFeature.News> {
    override fun invoke(
        action: LoginFeature.Action,
        effect: LoginFeature.Effect,
        state: LoginFeature.State
    ): LoginFeature.News? {
        return when (effect) {
            is LoginFeature.Effect.Loading -> LoginFeature.News.Loading(effect.loading)
            is LoginFeature.Effect.LoginSuccess -> LoginFeature.News.NavigateToHomeScreen
            is LoginFeature.Effect.LoginError -> LoginFeature.News.ShowError(effect.message)
        }
    }
}