package com.example.mvicorepoc.presentation.auth.login

import com.badoo.mvicore.element.Reducer

class LoginReducer : Reducer<LoginFeature.State, LoginFeature.Effect> {
    override fun invoke(
        state: LoginFeature.State,
        effect: LoginFeature.Effect
    ): LoginFeature.State {
        return when (effect) {
            is LoginFeature.Effect.Loading -> LoginFeature.State.LoadingState(effect.loading)
            is LoginFeature.Effect.LoginSuccess -> LoginFeature.State.SuccessState
            is LoginFeature.Effect.LoginError -> LoginFeature.State.ErrorState(effect.message)
        }
    }
}