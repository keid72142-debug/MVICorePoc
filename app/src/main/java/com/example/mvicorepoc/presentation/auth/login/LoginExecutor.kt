package com.example.mvicorepoc.presentation.auth.login


import com.example.mvicorepoc.R
import com.example.mvicorepoc.presentation.auth.login.component.ExecutionResult
import com.example.mvicorepoc.presentation.auth.login.utils.validateCredentials
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.Callable
import javax.inject.Inject

class LoginExecutor @Inject constructor() {
    fun checkUserValidation(wish: LoginFeature.Wish.Login): Observable<LoginFeature.Effect> {
        return Observable.fromCallable<ExecutionResult>(
            Callable {
                validateCredentials(wish.email, wish.password)
            }
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { result -> Observable.just(mapToEffect(result)) }

    }


    private fun mapToEffect(result: ExecutionResult): LoginFeature.Effect = when (result) {
        is ExecutionResult.EmailEmpty -> LoginFeature.Effect.EmailError(R.string.email_cannot_be_empty)
        is ExecutionResult.InvalidEmail -> LoginFeature.Effect.EmailError(R.string.invalid_email_format)
        is ExecutionResult.PasswordEmpty -> LoginFeature.Effect.PasswordError(R.string.password_cannot_be_empty)
        is ExecutionResult.PasswordTooShort -> LoginFeature.Effect.PasswordError(R.string.password_is_too_short)
        is ExecutionResult.ValidAuthData -> LoginFeature.Effect.LoginSuccess
    }

}