package com.example.mvicorepoc.presentation.auth.login


import com.example.mvicorepoc.presentation.auth.login.component.ExecutionResult
import com.example.mvicorepoc.presentation.auth.login.utils.validateCredentials
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.Callable

class LoginExecutor {
    fun checkUserValidation(wish: LoginFeature.Wish.Login): Observable<LoginFeature.Effect> {
        return Observable.fromCallable<ExecutionResult>(
            Callable {
                validateCredentials(wish.email, wish.password)
            }
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

            .map { result -> mapToEffect(result) }
            .startWithItem(LoginFeature.Effect.Loading(loading = true))

    }


    private fun mapToEffect(result: ExecutionResult): LoginFeature.Effect = when (result) {
        is ExecutionResult.HomeScreen -> LoginFeature.Effect.LoginSuccess
        is ExecutionResult.EmailEmpty -> LoginFeature.Effect.LoginError("Email cannot be empty")
        is ExecutionResult.PasswordEmpty -> LoginFeature.Effect.LoginError("Password cannot be empty")
        is ExecutionResult.InvalidEmail -> LoginFeature.Effect.LoginError("Invalid email format")
        is ExecutionResult.PasswordTooShort -> LoginFeature.Effect.LoginError("Password is too short")
        is ExecutionResult.ValidAuthData -> LoginFeature.Effect.LoginSuccess
    }


}