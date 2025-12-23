package com.example.mvicorepoc.presentation.home.effect

import com.badoo.mvicore.element.PostProcessor
import com.example.mvicorepoc.presentation.home.HomeFeature

class HomePostProcessor : PostProcessor<HomeFeature.Action, HomeFeature.Effect, HomeFeature.State> {
    override fun invoke(
        p1: HomeFeature.Action,
        p2: HomeFeature.Effect,
        p3: HomeFeature.State
    ): HomeFeature.Action? {
        return null

    }
}