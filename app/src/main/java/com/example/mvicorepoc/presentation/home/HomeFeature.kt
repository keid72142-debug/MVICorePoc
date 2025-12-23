package com.example.mvicorepoc.presentation.home

import com.badoo.mvicore.feature.BaseFeature
import com.example.mvicorepoc.presentation.home.effect.HomeNews
import com.example.mvicorepoc.presentation.home.effect.HomePostProcessor
import com.example.mvicorepoc.presentation.home.effect.HomeReducer
import com.example.mvicorepoc.presentation.home.ui.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeFeature @Inject constructor(
    actor: HomeActor,
) :
    BaseFeature<HomeFeature.Wish, HomeFeature.Action, HomeFeature.Effect, HomeFeature.State, HomeFeature.News>(
        initialState = State.InitState,
        actor = actor,
        reducer = HomeReducer(),
        postProcessor = HomePostProcessor(),
        newsPublisher = HomeNews(),
        wishToAction = { wish -> Action.ExecuteWish(wish) }
    ) {
    sealed class Wish {
        object FetchProducts : Wish()
    }

    sealed class Action {
        data class ExecuteWish(val wish: Wish) : Action()

    }

    sealed class Effect {
        data class Loading(val loading: Boolean) : Effect()
        data class SuccessState(val products: List<Product>) : Effect()
        data class ErrorState(val message: String) : Effect()


    }

    sealed class State {
        object InitState : State()
        data class LoadingState(val loading: Boolean) : State()
        data class SuccessState(val products: List<Product>) : State()
        data class ErrorState(val message: String) : State()

    }

    sealed class News

}