package com.example.mvicorepoc.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.badoo.mvicore.feature.BaseFeature
import com.example.mvicorepoc.presentation.auth.login.event.LoginEvents
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<
        Feature : BaseFeature<Wish, Action, Effect, State, News>,
        UIState : Any,
        State : Any,
        News : Any,
        Wish : Any,
        Action : Any,
        Effect : Any>(
    val feature: BaseFeature<Wish, Action, Effect, State, News>,
    initState: UIState,
) : ViewModel() {

    protected val _uiStateFlow: MutableStateFlow<UIState> = MutableStateFlow(initState)
    val uiStateFlow = _uiStateFlow.asStateFlow()

    protected val _newsState = MutableSharedFlow<News>()
    val newsFlow = _newsState.asSharedFlow()

    init {
        observeState()
        observeNews()
    }

    abstract suspend fun handleNews(news: News)
    abstract fun handleNewsError(error: Throwable)
    abstract suspend fun handeState(featureState: State)
    abstract fun handleStateError(error: Throwable)

    abstract fun handleUiEvent(event: LoginEvents)

    private fun observeState() {
        feature.subscribe(object : Observer<State> {
            override fun onSubscribe(d: Disposable) {


            }

            override fun onNext(s: State) {
                viewModelScope.launch {
                    handeState(s)

                }
            }

            override fun onError(e: Throwable) {
                viewModelScope.launch {
                    handleStateError(e)

                }
            }

            override fun onComplete() {
            }


        })
    }

    private fun observeNews() {
        feature.news.subscribe(object : Observer<News> {
            override fun onSubscribe(disposable: Disposable) {

            }

            override fun onNext(news: News) {
                viewModelScope.launch {
                    handleNews(news)
                }
            }

            override fun onError(error: Throwable) {
                handleNewsError(error)
            }

            override fun onComplete() {
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
        feature.dispose()
    }

}