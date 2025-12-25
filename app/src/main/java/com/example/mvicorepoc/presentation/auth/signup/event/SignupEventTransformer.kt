package com.example.mvicorepoc.presentation.auth.signup.event

import com.example.mvicorepoc.presentation.auth.signup.SignupFeature
import com.example.mvicorepoc.presentation.auth.signup.SignupFeature.Wish.Signup
import javax.inject.Inject

class SignupEventTransformer @Inject constructor() {

    operator fun invoke(event: SignupEvents): SignupFeature.Wish = when (event) {
        is SignupEvents.SignupButtonClicked -> Signup(
            event.fullName,
            event.email,
            event.birthDate,
            event.phoneNumber,
            event.password
        )

        SignupEvents.LoginButtonClicked -> SignupFeature.Wish.NavigateToLoginScreen

    }
}

