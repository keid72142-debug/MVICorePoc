package com.example.mvicorepoc.presentation.auth.signup


import com.example.mvicorepoc.presentation.auth.signup.component.ExecutionResult
import com.example.mvicorepoc.presentation.auth.signup.utils.validateSignupData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.Callable
import javax.inject.Inject

class SignupExecutor @Inject constructor() {
    fun checkSignupValidation(wish: SignupFeature.Wish.Signup): Observable<SignupFeature.Effect> {
        return Observable.fromCallable<ExecutionResult>(
            Callable {
                validateSignupData(
                    wish.fullName,
                    wish.email,
                    wish.birthDate,
                    wish.phoneNumber,
                    wish.password
                )
            }
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { result -> mapToEffect(result) }

    }


    private fun mapToEffect(result: ExecutionResult): SignupFeature.Effect = when (result) {
        is ExecutionResult.FullNameEmpty -> SignupFeature.Effect.SignupError("Full name cannot be empty")
        is ExecutionResult.EmailEmpty -> SignupFeature.Effect.SignupError("Email cannot be empty")
        is ExecutionResult.BirthDateEmpty -> SignupFeature.Effect.SignupError("Birth date cannot be empty")
        is ExecutionResult.PhoneNumberEmpty -> SignupFeature.Effect.SignupError("Phone number cannot be empty")
        is ExecutionResult.PasswordEmpty -> SignupFeature.Effect.SignupError("Password cannot be empty")
        is ExecutionResult.InvalidEmail -> SignupFeature.Effect.SignupError("Invalid email format")
        is ExecutionResult.InvalidBirthDate -> SignupFeature.Effect.SignupError("Invalid birth date format")
        is ExecutionResult.PasswordTooShort -> SignupFeature.Effect.SignupError("Password is too short")
        is ExecutionResult.ValidSignupData -> SignupFeature.Effect.SignupSuccess
    }


}

