package com.example.mvicorepoc.presentation.auth.login.effect

import com.badoo.mvicore.element.Reducer
import com.example.mvicorepoc.presentation.auth.login.LoginFeature
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
            is LoginFeature.Effect.PasswordError -> LoginFeature.State.PasswordErrorState(effect.errorMessage)
            is LoginFeature.Effect.EmailError -> LoginFeature.State.EmailErrorState(effect.errorMessage)
            LoginFeature.Effect.NavigateToSignupScreen -> InitState

        }
    }
}