package com.example.mvicorepoc.presentation.home

import com.example.mvicorepoc.data.repository.ProductRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomeExecutor @Inject constructor(
    private val productRepository: ProductRepository

) {

    fun fetchProducts(): Observable<out HomeFeature.Effect> {
        return Observable.concat(
            Observable.just(HomeFeature.Effect.Loading(true)),

            productRepository.getProducts()
                .subscribeOn(Schedulers.io())
                .map<HomeFeature.Effect> { products ->
                    HomeFeature.Effect.SuccessState(products)
                }.toObservable()
        )
            .observeOn(AndroidSchedulers.mainThread())
    }
}