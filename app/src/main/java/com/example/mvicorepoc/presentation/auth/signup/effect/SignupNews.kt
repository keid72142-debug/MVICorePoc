package com.example.mvicorepoc.presentation.auth.signup.effect

import com.badoo.mvicore.element.NewsPublisher
import com.example.mvicorepoc.presentation.auth.signup.SignupFeature
import com.example.mvicorepoc.presentation.auth.signup.SignupFeature.News.NavigateToHomeScreen
import com.example.mvicorepoc.presentation.auth.signup.SignupFeature.News.NavigateToLoginScreen
import com.example.mvicorepoc.presentation.auth.signup.SignupFeature.News.ShowError

class SignupNews :
    NewsPublisher<SignupFeature.Action, SignupFeature.Effect, SignupFeature.State, SignupFeature.News> {
    override fun invoke(
        action: SignupFeature.Action,
        effect: SignupFeature.Effect,
        state: SignupFeature.State
    ): SignupFeature.News? {
        return when (effect) {
            is SignupFeature.Effect.Loading -> null
            is SignupFeature.Effect.SignupSuccess -> NavigateToHomeScreen
            is SignupFeature.Effect.SignupError -> ShowError(effect.message)
            SignupFeature.Effect.NavigateToLoginScreen -> NavigateToLoginScreen

        }
    }
}

