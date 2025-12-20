package com.example.mvicorepoc.presentation.auth.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvicorepoc.R
import com.example.mvicorepoc.presentation.auth.component.TextFieldInput
import com.example.mvicorepoc.presentation.auth.signup.component.BottomOfSignup
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
    SignupContent(modifier)
}

@Composable
fun SignupContent(modifier: Modifier = Modifier) {

    var email by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isDateValid by remember { mutableStateOf(false) }



    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(MaterialTheme.spacing.s16),
    ) {

        TopBar()

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
            onButtonClick = { /*TODO*/ },
            buttonText = R.string.register
        )
        BottomOfSignup()
    }
}


@Preview(showBackground = true)
@Composable
fun SignupPreview() {
    MVICorePocTheme {
        SignupContent()
    }
}