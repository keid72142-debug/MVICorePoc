package com.example.mvicorepoc.presentation.auth.signup.ui

import com.example.mvicorepoc.presentation.auth.signup.SignupFeature
import com.example.mvicorepoc.presentation.auth.signup.event.SignupEventTransformer
import com.example.mvicorepoc.presentation.auth.signup.event.SignupEvents
import com.example.mvicorepoc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    feature: SignupFeature,
    private val transformer: SignupEventTransformer
) : BaseViewModel<
        SignupFeature,
        SignupUIState,
        SignupFeature.State,
        SignupFeature.News,
        SignupFeature.Wish,
        SignupFeature.Action,
        SignupFeature.Effect,
        SignupEvents>(
    feature = feature,
    initState = SignupUIState(),
) {

    override fun handleUiEvent(event: SignupEvents) {
        val wish = transformer(event)
        feature.accept(wish)
    }

    override suspend fun handleNews(news: SignupFeature.News) {
        _newsState.emit(news)
    }

    override fun handleNewsError(error: Throwable) {
        _uiStateFlow.value = SignupUIState(isLoading = false)

    }

    override suspend fun handeState(featureState: SignupFeature.State) {
        _uiStateFlow.emit(
            when (featureState) {
                is SignupFeature.State.InitState -> SignupUIState()
                is SignupFeature.State.LoadingState -> SignupUIState(isLoading = featureState.loading)
                is SignupFeature.State.SuccessState -> SignupUIState(isLoading = false)
                is SignupFeature.State.ErrorState -> SignupUIState(isLoading = false)
            }
        )
    }

    override fun handleStateError(error: Throwable) {
        _uiStateFlow.value = SignupUIState(isLoading = false)
    }


}

