package com.example.mvicorepoc.presentation.home

import com.badoo.mvicore.element.Actor
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class HomeActor @Inject constructor(
    private var homeExecutor: HomeExecutor

) : Actor<HomeFeature.State, HomeFeature.Action, HomeFeature.Effect> {
    override fun invoke(
        state: HomeFeature.State,
        action: HomeFeature.Action
    ): Observable<out HomeFeature.Effect> {
        return when (action) {
            is HomeFeature.Action.ExecuteWish -> executeWish(action.wish)
        }
    }


    private fun executeWish(wish: HomeFeature.Wish): Observable<out HomeFeature.Effect> =
        when (wish) {
            is HomeFeature.Wish.FetchProducts -> fetchProducts()
        }

    private fun fetchProducts(): Observable<out HomeFeature.Effect> {
        return homeExecutor.fetchProducts()

    }

}