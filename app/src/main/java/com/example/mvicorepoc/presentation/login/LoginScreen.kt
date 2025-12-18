package com.example.mvicorepoc.presentation.login

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvicorepoc.R
import com.example.mvicorepoc.presentation.component.BaseButton
import com.example.mvicorepoc.presentation.login.component.BottomOfLogin
import com.example.mvicorepoc.presentation.login.component.HeaderOfLogin
import com.example.mvicorepoc.presentation.login.component.TextFieldInput
import com.example.mvicorepoc.presentation.theme.MVICorePocTheme
import com.example.mvicorepoc.presentation.theme.spacing

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    LoginContent(modifier)
}

@Composable
fun LoginContent(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .scrollable(
                state = rememberScrollableState { delta -> delta },
                orientation = androidx.compose.foundation.gestures.Orientation.Vertical
            )
            .fillMaxSize()
            .padding(MaterialTheme.spacing.s16),
    ) {
        HeaderOfLogin()
        TextFieldInput(
            titleOfTextField = R.string.email,
            label = R.string.email,
            onValueChange = { email = it },
            value = email
        )
        TextFieldInput(
            titleOfTextField = R.string.password,
            label = R.string.password,
            onValueChange = { password = it },
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
            onButtonClick = { /*TODO*/ },
            buttonText = R.string.login
        )
        BottomOfLogin()


    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    MVICorePocTheme {
        LoginContent()
    }
}