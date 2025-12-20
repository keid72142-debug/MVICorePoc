package com.example.mvicorepoc.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val feature: LoginFeature = LoginFeature()
) : ViewModel() {

    private val transformer = LoginEventTransformer()

    var uiState = MutableStateFlow(LoginUIState())

    private val _news = MutableSharedFlow<LoginFeature.News>(replay = 0)
    val news: SharedFlow<LoginFeature.News> = _news.asSharedFlow()

    init {
        feature.news.subscribe(object : Observer<LoginFeature.News> {
            override fun onSubscribe(d: Disposable) {}
            override fun onNext(item: LoginFeature.News) {
                viewModelScope.launch {
                    _news.emit(item)
                }
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
            }
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

