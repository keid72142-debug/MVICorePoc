package com.example.mvicorepoc.presentation.auth.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvicorepoc.R
import com.example.mvicorepoc.presentation.auth.component.TextFieldInput
import com.example.mvicorepoc.presentation.auth.signup.component.BottomOfSignup
import com.example.mvicorepoc.presentation.auth.signup.event.SignupEvents
import com.example.mvicorepoc.presentation.auth.signup.ui.SignupUIState
import com.example.mvicorepoc.presentation.auth.signup.ui.SignupViewModel
import com.example.mvicorepoc.presentation.component.BaseButton
import com.example.mvicorepoc.presentation.component.TopBar
import com.example.mvicorepoc.presentation.theme.MVICorePocTheme
import com.example.mvicorepoc.presentation.theme.spacing

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit,
    onNavigateToLogin: () -> Unit

) {
    val viewModel: SignupViewModel = hiltViewModel()
    val uiState by viewModel.uiStateFlow.collectAsState()
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.newsFlow.collect { news ->
            when (news) {
                is SignupFeature.News.NavigateToHomeScreen -> {
                    onNavigateToHome()
                }

                is SignupFeature.News.ShowError -> {
                    snackBarHostState.showSnackbar(
                        news.message,
                        duration = SnackbarDuration.Short
                    )
                }

                is SignupFeature.News.NavigateToLoginScreen -> {
                    onNavigateToLogin()
                }
            }
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        SignupContent(
            modifier = modifier,
            signupEvents = { viewModel.handleUiEvent(it) },
            signupUIState = uiState
        )

        SnackbarHost(
            hostState = snackBarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun SignupContent(
    modifier: Modifier = Modifier,
    signupEvents: (SignupEvents) -> Unit,
    signupUIState: SignupUIState
) {

    var email by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isDateValid by remember { mutableStateOf(false) }



    if (signupUIState.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(MaterialTheme.spacing.s16),
        ) {

        TopBar(
            backButtonClick = {

            }
        )

        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.s32),
            text = stringResource(R.string.sign_up),
            style = MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.s12),
            text = stringResource(R.string.create_an_account_to_continue),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.surfaceVariant,
        )


        TextFieldInput(
            modifier = Modifier.padding(top = MaterialTheme.spacing.s32),
            titleOfTextField = R.string.full_name,
            placeholder = R.string.full_name,
            onValueChange = { fullName = it },
            value = fullName
        )

        TextFieldInput(
            modifier = Modifier.padding(top = MaterialTheme.spacing.s16),
            titleOfTextField = R.string.email,
            placeholder = R.string.email,
            keyboardType = KeyboardType.Email,

            onValueChange = { email = it },
            value = email
        )
        TextFieldInput(
            modifier = Modifier.padding(top = MaterialTheme.spacing.s16),
            titleOfTextField = R.string.birth_of_date,
            placeholder = R.string.birth_of_date,
            onValueChange = {
                birthDate = it
            },
            isError = isDateValid,
            value = birthDate
        )
        TextFieldInput(
            modifier = Modifier.padding(top = MaterialTheme.spacing.s16),
            titleOfTextField = R.string.phone_number,
            placeholder = R.string.phone_number,
            keyboardType = KeyboardType.Phone,
            onValueChange = { phoneNumber = it },
            value = phoneNumber
        )
        TextFieldInput(
            modifier = Modifier.padding(top = MaterialTheme.spacing.s16),
            titleOfTextField = R.string.set_password,
            placeholder = R.string.set_password,
            keyboardType = KeyboardType.Password,
            onValueChange = { password = it },
            value = password,
            passwordVisible = passwordVisible,
            onTrailingIconClick = { passwordVisible = !passwordVisible },
            isPasswordType = true

        )
            BaseButton(
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.s32)
                    .fillMaxWidth(),
                onButtonClick = {
                    signupEvents(
                        SignupEvents.SignupButtonClicked(
                            fullName,
                            email,
                            birthDate,
                            phoneNumber,
                            password
                        )
                    )
                },
                buttonText = R.string.register
            )
            BottomOfSignup(
                onLoginClick = {
                    signupEvents(SignupEvents.LoginButtonClicked)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignupPreview() {
    MVICorePocTheme {
        SignupContent(
            signupEvents = {},
            signupUIState = SignupUIState()
        )
    }
}