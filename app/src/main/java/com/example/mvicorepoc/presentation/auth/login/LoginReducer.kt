package com.example.mvicorepoc.presentation.auth.login

import com.badoo.mvicore.element.Reducer
import com.example.mvicorepoc.presentation.auth.login.LoginFeature.State.ErrorState
import com.example.mvicorepoc.presentation.auth.login.LoginFeature.State.InitState
import com.example.mvicorepoc.presentation.auth.login.LoginFeature.State.LoadingState
import com.example.mvicorepoc.presentation.auth.login.LoginFeature.State.SuccessState

class LoginReducer : Reducer<LoginFeature.State, LoginFeature.Effect> {
    override fun invoke(
        state: LoginFeature.State,
        effect: LoginFeature.Effect
    ): LoginFeature.State {
        return when (effect) {
            is LoginFeature.Effect.Loading -> LoadingState(effect.loading)
            is LoginFeature.Effect.LoginSuccess -> SuccessState
            is LoginFeature.Effect.LoginError -> ErrorState(effect.message)
            LoginFeature.Effect.NavigateToSignupScreen -> InitState

        }
    }
}