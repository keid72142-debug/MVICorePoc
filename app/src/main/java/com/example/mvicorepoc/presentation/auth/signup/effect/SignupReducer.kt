package com.example.mvicorepoc.presentation.auth.signup.effect

import com.badoo.mvicore.element.Reducer
import com.example.mvicorepoc.presentation.auth.signup.SignupFeature
import com.example.mvicorepoc.presentation.auth.signup.SignupFeature.State.ErrorState
import com.example.mvicorepoc.presentation.auth.signup.SignupFeature.State.InitState
import com.example.mvicorepoc.presentation.auth.signup.SignupFeature.State.LoadingState
import com.example.mvicorepoc.presentation.auth.signup.SignupFeature.State.SuccessState

class SignupReducer : Reducer<SignupFeature.State, SignupFeature.Effect> {
    override fun invoke(
        state: SignupFeature.State,
        effect: SignupFeature.Effect
    ): SignupFeature.State {
        return when (effect) {
            is SignupFeature.Effect.Loading -> LoadingState(effect.loading)
            is SignupFeature.Effect.SignupSuccess -> SuccessState
            is SignupFeature.Effect.SignupError -> ErrorState(effect.message)
            SignupFeature.Effect.NavigateToLoginScreen -> InitState

        }
    }
}

