package com.example.mvicorepoc.presentation.auth.login.ui

import com.example.mvicorepoc.presentation.auth.login.LoginFeature
import com.example.mvicorepoc.presentation.auth.login.event.LoginEventTransformer
import com.example.mvicorepoc.presentation.auth.login.event.LoginEvents
import com.example.mvicorepoc.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    feature: LoginFeature,
    private val transformer: LoginEventTransformer
) : BaseViewModel<
        LoginFeature,
        LoginUIState,
        LoginFeature.State,
        LoginFeature.News,
        LoginFeature.Wish,
        LoginFeature.Action,
        LoginFeature.Effect,
        LoginEvents>(
    feature = feature,
    initState = LoginUIState(),
) {

    override fun handleUiEvent(event: LoginEvents) {
        val wish = transformer(event)
        feature.accept(wish)
    }

    override suspend fun handleNews(news: LoginFeature.News) {
        _newsState.emit(news)
    }

    override fun handleNewsError(error: Throwable) {
        _uiStateFlow.value = LoginUIState(isLoading = false)
    }

    override suspend fun handeState(featureState: LoginFeature.State) {
        _uiStateFlow.emit(
            when (featureState) {
                is LoginFeature.State.InitState -> LoginUIState()
                is LoginFeature.State.LoadingState -> LoginUIState(isLoading = featureState.loading)
                is LoginFeature.State.SuccessState -> LoginUIState(isLoading = false)
                is LoginFeature.State.EmailErrorState -> LoginUIState(
                    isLoading = false,
                    emailError = featureState.message
                )

                is LoginFeature.State.PasswordErrorState -> LoginUIState(
                    isLoading = false,
                    passwordError = featureState.message
                )
            }
        )
    }

    override fun handleStateError(error: Throwable) {
        _uiStateFlow.value = LoginUIState(isLoading = false)
    }


}