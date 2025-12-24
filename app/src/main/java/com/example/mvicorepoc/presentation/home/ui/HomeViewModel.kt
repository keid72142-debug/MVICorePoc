package com.example.mvicorepoc.presentation.home.ui

import com.example.mvicorepoc.presentation.auth.login.event.LoginEvents
import com.example.mvicorepoc.presentation.base.BaseViewModel
import com.example.mvicorepoc.presentation.home.HomeFeature
import com.example.mvicorepoc.presentation.home.event.HomeEventTransformer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    feature: HomeFeature,
    private val transformer: HomeEventTransformer
) : BaseViewModel<
        HomeFeature,
        HomeUIState,
        HomeFeature.State,
        HomeFeature.News,
        HomeFeature.Wish,
        HomeFeature.Action,
        HomeFeature.Effect>(
    feature = feature,
    initState = HomeUIState()
) {

    init {
        fetchProducts()
    }


    private fun fetchProducts() {
        feature.accept(HomeFeature.Wish.FetchProducts)
    }

    override suspend fun handleNews(news: HomeFeature.News) {}
    override fun handleNewsError(error: Throwable) {}

    override suspend fun handeState(featureState: HomeFeature.State) {
        _uiStateFlow.emit(
            when (featureState) {
                is HomeFeature.State.InitState -> HomeUIState()
                is HomeFeature.State.LoadingState -> HomeUIState(isLoading = featureState.loading)
                is HomeFeature.State.SuccessState -> HomeUIState(
                    products = featureState.products
                )

                is HomeFeature.State.ErrorState -> HomeUIState(
                    isLoading = false,
                    error = featureState.message
                )
            }
        )
    }

    override fun handleStateError(error: Throwable) {
        _uiStateFlow.value = HomeUIState(isLoading = false)

    }

    override fun handleUiEvent(event: LoginEvents) {}


    override fun onCleared() {
        super.onCleared()
        feature.dispose()
    }

}