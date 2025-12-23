package com.example.mvicorepoc.presentation.home.effect

import com.badoo.mvicore.element.Reducer
import com.example.mvicorepoc.presentation.home.HomeFeature

class HomeReducer : Reducer<HomeFeature.State, HomeFeature.Effect> {
    override fun invoke(
        state: HomeFeature.State,
        effect: HomeFeature.Effect
    ): HomeFeature.State {
        return when (effect) {
            is HomeFeature.Effect.Loading -> HomeFeature.State.LoadingState(effect.loading)
            is HomeFeature.Effect.SuccessState -> HomeFeature.State.SuccessState(products = effect.products)
            is HomeFeature.Effect.ErrorState -> HomeFeature.State.ErrorState(effect.message)


        }

    }
}