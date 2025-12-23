package com.example.mvicorepoc.presentation.auth.login

import com.badoo.mvicore.element.Actor
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject


class LoginActor @Inject constructor(
    private var loginExecutor: LoginExecutor
) : Actor<LoginFeature.State, LoginFeature.Action, LoginFeature.Effect> {


    override fun invoke(
        state: LoginFeature.State, action: LoginFeature.Action
    ): Observable<out LoginFeature.Effect> {
        return when (action) {
            is LoginFeature.Action.ExecuteWish -> executeWish(action.wish)

        }


    }


    private fun executeWish(wish: LoginFeature.Wish): Observable<out LoginFeature.Effect> =
        when (wish) {
            is LoginFeature.Wish.Login -> checkUserValidation(wish)
            LoginFeature.Wish.NavigateToSignupScreen -> Observable.just(LoginFeature.Effect.NavigateToSignupScreen)
        }

    private fun checkUserValidation(wish: LoginFeature.Wish.Login): Observable<LoginFeature.Effect> {
        return loginExecutor.checkUserValidation(wish)

    }


}