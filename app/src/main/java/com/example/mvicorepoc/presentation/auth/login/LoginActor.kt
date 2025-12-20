package com.example.mvicorepoc.presentation.auth.login

import com.badoo.mvicore.element.Actor
import io.reactivex.rxjava3.core.Observable


class LoginActor() : Actor<LoginFeature.State, LoginFeature.Action, LoginFeature.Effect> {

    private lateinit var loginExecutor: LoginExecutor

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
        }

    private fun checkUserValidation(wish: LoginFeature.Wish.Login): Observable<LoginFeature.Effect> {
        if (!::loginExecutor.isInitialized) loginExecutor = LoginExecutor()
        return loginExecutor.checkUserValidation(wish)

    }


}