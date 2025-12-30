package com.example.mvicorepoc.presentation.auth.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvicorepoc.R
import com.example.mvicorepoc.presentation.theme.MVICorePocTheme
import com.example.mvicorepoc.presentation.theme.spacing

@Composable
fun TextFieldInput(
    modifier: Modifier = Modifier,
    @StringRes titleOfTextField: Int,
    @StringRes placeholder: Int,
    value: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit,
    passwordVisible: Boolean = false,
    onTrailingIconClick: () -> Unit = {},
    isPasswordType: Boolean = false,
    isError: Boolean = false
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(titleOfTextField),
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.surfaceVariant,
        )
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            placeholder = { Text(stringResource(placeholder)) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.s8),
            shape = MaterialTheme.shapes.medium,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            colors = OutlinedTextFieldDefaults.colors(
                errorLabelColor = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface,
                errorBorderColor = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface,

            ),
            isError = isError,
            visualTransformation = if (isPasswordType) if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                if (isPasswordType)
                    IconButton(onClick = { onTrailingIconClick() }) {
                        Icon(
                            painter = if (passwordVisible)
                                painterResource(id = R.drawable.open_eye)
                            else
                                painterResource(id = R.drawable.close_eye),
                            contentDescription = null
                        )
                    }
            },
        )
    }
}

@Preview
@Composable
private fun TextFieldInputPreview() {
    MVICorePocTheme {
        TextFieldInput(
            titleOfTextField = R.string.email,
            placeholder = R.string.email,
            onValueChange = {},
            value = "sdfsdfsd",
            isError = true

        )
    }

}