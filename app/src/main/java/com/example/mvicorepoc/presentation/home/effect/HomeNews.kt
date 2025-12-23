package com.example.mvicorepoc.presentation.home.effect

import com.badoo.mvicore.element.NewsPublisher
import com.example.mvicorepoc.presentation.home.HomeFeature

class HomeNews :
    NewsPublisher<HomeFeature.Action, HomeFeature.Effect, HomeFeature.State, HomeFeature.News> {
    override fun invoke(
        action: HomeFeature.Action,
        effect: HomeFeature.Effect,
        state: HomeFeature.State
    ): HomeFeature.News? {
        return null
    }
}