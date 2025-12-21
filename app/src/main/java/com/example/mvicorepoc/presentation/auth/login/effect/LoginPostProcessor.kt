package com.example.mvicorepoc.presentation.auth.login.effect

import com.badoo.mvicore.element.PostProcessor
import com.example.mvicorepoc.presentation.auth.login.LoginFeature

class LoginPostProcessor :
    PostProcessor<LoginFeature.Action, LoginFeature.Effect, LoginFeature.State> {
    override fun invoke(
        action: LoginFeature.Action,
        effect: LoginFeature.Effect,
        state: LoginFeature.State
    ): LoginFeature.Action? {
        // PostProcessor should return null to prevent re-processing the same action
        // Returning the same action can cause infinite loops in MVICore
        // Only return a new action if you explicitly need to trigger a new action flow
        return null
    }
}