package com.example.mvicorepoc.presentation.auth.signup.effect

import com.badoo.mvicore.element.PostProcessor
import com.example.mvicorepoc.presentation.auth.signup.SignupFeature

class SignupPostProcessor :
    PostProcessor<SignupFeature.Action, SignupFeature.Effect, SignupFeature.State> {
    override fun invoke(
        action: SignupFeature.Action,
        effect: SignupFeature.Effect,
        state: SignupFeature.State
    ): SignupFeature.Action? {
        return null
    }
}

