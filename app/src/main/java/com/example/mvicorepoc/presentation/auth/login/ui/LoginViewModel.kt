package com.example.mvicorepoc.presentation.auth.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvicorepoc.presentation.auth.login.LoginFeature
import com.example.mvicorepoc.presentation.auth.login.event.LoginEventTransformer
import com.example.mvicorepoc.presentation.auth.login.event.LoginEvents
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val feature: LoginFeature = LoginFeature()
) : ViewModel() {

    private val transformer = LoginEventTransformer()

    private var _uiState = MutableStateFlow(LoginUIState())
    val uiState = _uiState.asStateFlow()


    private val _news = MutableSharedFlow<LoginFeature.News>()
    val news: SharedFlow<LoginFeature.News> = _news.asSharedFlow()

    init {
        observeState()
        observeNews()
    }

    private fun observeState() {
        feature.subscribe(object : Observer<LoginFeature.State> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(state: LoginFeature.State) {
                viewModelScope.launch {
                    _uiState.emit(
                        when (state) {
                            is LoginFeature.State.InitState -> LoginUIState()
                            is LoginFeature.State.LoadingState -> LoginUIState(loading = state.loading)
                            is LoginFeature.State.SuccessState -> LoginUIState(loading = false)
                            is LoginFeature.State.ErrorState -> LoginUIState(loading = false)
                        }
                    )
                }
            }

            override fun onError(e: Throwable) {
                viewModelScope.launch {
                    _uiState.emit(LoginUIState(loading = false))
                }
            }

            override fun onComplete() {

            }

        })
    }

    private fun observeNews() {
        feature.news.subscribe(object : Observer<LoginFeature.News> {
            override fun onSubscribe(d: Disposable) {}
            override fun onNext(item: LoginFeature.News) {
                viewModelScope.launch {
                    _news.emit(item)
                }
            }

            override fun onError(e: Throwable) {}
            override fun onComplete() {}
        })

    }

    fun handleUiEvent(event: LoginEvents) {
        feature.accept(transformer(event))
    }

    override fun onCleared() {
        super.onCleared()
        feature.dispose()
    }
}