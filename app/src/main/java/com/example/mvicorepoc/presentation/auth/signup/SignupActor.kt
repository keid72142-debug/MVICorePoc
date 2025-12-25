package com.example.mvicorepoc.presentation.auth.signup

import com.badoo.mvicore.element.Actor
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject


class SignupActor @Inject constructor(
    private var signupExecutor: SignupExecutor
) : Actor<SignupFeature.State, SignupFeature.Action, SignupFeature.Effect> {


    override fun invoke(
        state: SignupFeature.State, action: SignupFeature.Action
    ): Observable<out SignupFeature.Effect> {
        return when (action) {
            is SignupFeature.Action.ExecuteWish -> executeWish(action.wish)

        }


    }


    private fun executeWish(wish: SignupFeature.Wish): Observable<out SignupFeature.Effect> =
        when (wish) {
            is SignupFeature.Wish.Signup -> checkSignupValidation(wish)
            SignupFeature.Wish.NavigateToLoginScreen -> Observable.just(SignupFeature.Effect.NavigateToLoginScreen)
        }

    private fun checkSignupValidation(wish: SignupFeature.Wish.Signup): Observable<SignupFeature.Effect> {
        return signupExecutor.checkSignupValidation(wish)

    }


}

