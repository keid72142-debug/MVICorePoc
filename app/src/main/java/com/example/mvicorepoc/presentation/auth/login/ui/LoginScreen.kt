package com.example.mvicorepoc.presentation.auth.login.ui

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
import com.example.mvicorepoc.presentation.auth.login.LoginFeature
import com.example.mvicorepoc.presentation.auth.login.component.BottomOfLogin
import com.example.mvicorepoc.presentation.auth.login.component.HeaderOfLogin
import com.example.mvicorepoc.presentation.auth.login.event.LoginEvents
import com.example.mvicorepoc.presentation.component.BaseButton
import com.example.mvicorepoc.presentation.theme.MVICorePocTheme
import com.example.mvicorepoc.presentation.theme.spacing

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit,
    onNavigateToSignup: () -> Unit
) {
    val viewModel: LoginViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.news.collect { news ->
            when (news) {
                is LoginFeature.News.NavigateToHomeScreen -> {
                    onNavigateToHome()
                }

                is LoginFeature.News.ShowError -> {
                        snackbarHostState.showSnackbar(
                            news.message,
                            duration = SnackbarDuration.Short
                        )
                }

                is LoginFeature.News.NavigateToSignupScreen -> {
                    onNavigateToSignup()
                }
            }
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        LoginContent(
            modifier = modifier,
            loginEvents = viewModel::handleUiEvent,
            loginUIState = uiState
        )

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    loginEvents: (LoginEvents) -> Unit,
    loginUIState: LoginUIState
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    if (loginUIState.isLoading) {
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
            HeaderOfLogin()
            TextFieldInput(
                modifier = Modifier.padding(top = MaterialTheme.spacing.s32),
                titleOfTextField = R.string.email,
                placeholder = R.string.email,
                keyboardType = KeyboardType.Email,
                onValueChange = { email = it },
                value = email
            )
            TextFieldInput(
                modifier = Modifier.padding(top = MaterialTheme.spacing.s32),
                titleOfTextField = R.string.password,
                placeholder = R.string.password,
                onValueChange = { password = it },
                keyboardType = KeyboardType.Password,
                value = password,
                passwordVisible = passwordVisible,
                onTrailingIconClick = { passwordVisible = !passwordVisible },
                isPasswordType = true

            )
            Text(
                stringResource(R.string.forgot_password),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = MaterialTheme.spacing.s8),
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            )
            BaseButton(
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.s32)
                    .fillMaxWidth(),
                onButtonClick = {
                    loginEvents(LoginEvents.LoginButtonClicked(email, password))
                },
                buttonText = R.string.login
            )
            BottomOfLogin(
                onSignupClick = {
                    loginEvents(LoginEvents.SignUpButtonClicked)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    MVICorePocTheme {
        LoginContent(
            loginEvents = {},
            loginUIState = LoginUIState()
        )
    }
}