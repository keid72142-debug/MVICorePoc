package com.example.mvicorepoc.presentation.auth.login

import com.badoo.mvicore.feature.BaseFeature

class LoginFeature :
    BaseFeature<LoginFeature.Wish, LoginFeature.Action, LoginFeature.Effect, LoginFeature.State, LoginFeature.News>(
        initialState = State.InitState,
        actor = LoginActor(),
        reducer = LoginReducer(),
        postProcessor = LoginPostProcessor(),
        newsPublisher = LoginNews(),
        wishToAction = { wish -> Action.ExecuteWish(wish) }
    ) {

    sealed class Wish {
        data class Login(val email: String, val password: String) : Wish()
    }

    sealed class Effect {
        data class Loading(val loading: Boolean) : Effect()
        object LoginSuccess : Effect()
        data class LoginError(val message: String) : Effect()
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
        data class ShowError(val message: String) : News()
    }
}