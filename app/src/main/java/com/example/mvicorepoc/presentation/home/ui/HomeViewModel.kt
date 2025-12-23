package com.example.mvicorepoc.presentation.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvicorepoc.presentation.home.HomeActor
import com.example.mvicorepoc.presentation.home.HomeFeature
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeActor: HomeActor
) : ViewModel() {
    private val feature: HomeFeature = HomeFeature(homeActor)

    private var _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()

    init {
        observeState()
        fetchProducts()
    }


    private fun fetchProducts() {
        feature.accept(HomeFeature.Wish.FetchProducts)
    }

    private fun observeState() {
        feature.subscribe(object : Observer<HomeFeature.State> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(state: HomeFeature.State) {
                viewModelScope.launch {
                    _uiState.emit(
                        when (state) {
                            is HomeFeature.State.InitState -> HomeUIState()
                            is HomeFeature.State.LoadingState -> HomeUIState(isLoading = state.loading)
                            is HomeFeature.State.SuccessState -> HomeUIState(
                                products = state.products
                            )

                            is HomeFeature.State.ErrorState -> HomeUIState(
                                isLoading = false,
                                error = state.message
                            )
                        }
                    )
                }
            }

            override fun onError(e: Throwable) {
                viewModelScope.launch {
                    _uiState.emit(HomeUIState(isLoading = false))
                }
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