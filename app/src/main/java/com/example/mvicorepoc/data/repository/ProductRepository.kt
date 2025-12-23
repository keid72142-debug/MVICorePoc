package com.example.mvicorepoc.data.repository

import com.example.mvicorepoc.presentation.home.ui.Product
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
) {
    fun getProducts(): Single<List<Product>> {
        return Single.just(
            listOf(
                Product(
                    id = "1",
                    name = "Product 1",
                    description = "This is a description for Product 1",
                    price = 29.99
                ),
                Product(
                    id = "2",
                    name = "Product 2",
                    description = "This is a description for Product 2",
                    price = 39.99
                ),
                Product(
                    id = "3",
                    name = "Product 3",
                    description = "This is a description for Product 3",
                    price = 49.99
                ),
                Product(
                    id = "4",
                    name = "Product 4",
                    description = "This is a description for Product 4",
                    price = 59.99
                ),
                Product(
                    id = "5",
                    name = "Product 5",
                    description = "This is a description for Product 5",
                    price = 69.99
                )
            )
        )
            .delay(5, TimeUnit.SECONDS)
    }
}

