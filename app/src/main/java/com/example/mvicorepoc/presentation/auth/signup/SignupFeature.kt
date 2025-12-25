package com.example.mvicorepoc.presentation.auth.signup

import com.badoo.mvicore.feature.BaseFeature
import com.example.mvicorepoc.presentation.auth.signup.effect.SignupNews
import com.example.mvicorepoc.presentation.auth.signup.effect.SignupPostProcessor
import com.example.mvicorepoc.presentation.auth.signup.effect.SignupReducer
import javax.inject.Inject

class SignupFeature @Inject constructor(
    actor: SignupActor,
) :
    BaseFeature<SignupFeature.Wish, SignupFeature.Action, SignupFeature.Effect, SignupFeature.State, SignupFeature.News>(
        initialState = State.InitState,
        actor = actor,
        reducer = SignupReducer(),
        postProcessor = SignupPostProcessor(),
        newsPublisher = SignupNews(),
        wishToAction = { wish -> Action.ExecuteWish(wish) }
    ) {

    sealed class Wish {
        data class Signup(
            val fullName: String,
            val email: String,
            val birthDate: String,
            val phoneNumber: String,
            val password: String
        ) : Wish()

        object NavigateToLoginScreen : Wish()
    }

    sealed class Effect {
        data class Loading(val loading: Boolean) : Effect()
        object SignupSuccess : Effect()
        data class SignupError(val message: String) : Effect()

        object NavigateToLoginScreen : Effect()

    }


    sealed class State {
        object InitState : State()
        data class LoadingState(val loading: Boolean) : State()
        object SuccessState : State()
        data class ErrorState(val message: String) : State()
    }

    sealed class Action {
        data class ExecuteWish(val wish: Wish) : Action()

    }

    sealed class News {
        object NavigateToHomeScreen : News()
        object NavigateToLoginScreen : News()

        data class ShowError(val message: String) : News()
    }
}

