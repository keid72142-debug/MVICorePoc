package com.example.mvicorepoc.presentation.login.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.mvicorepoc.R
import com.example.mvicorepoc.presentation.theme.spacing

@Composable
fun TextFieldInput(modifier: Modifier = Modifier,
                   @StringRes titleOfTextField: Int,
                   @StringRes label: Int,
                   value: String,
                   onValueChange: (String) -> Unit,
                   passwordVisible: Boolean = false,
                   onTrailingIconClick: () -> Unit = {},
                   isPasswordType: Boolean = false) {

    Text(
        modifier = modifier.padding(top = MaterialTheme.spacing.s32),
        text= stringResource(titleOfTextField),
        style = MaterialTheme.typography.labelSmall,
        fontWeight = FontWeight.Normal,
        color = MaterialTheme.colorScheme.surfaceVariant,
    )
    OutlinedTextField(
        value =value,
        onValueChange = { onValueChange(it) },
        label = { Text(stringResource(label)) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,

        visualTransformation = if(isPasswordType) if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            if(isPasswordType)
            IconButton(onClick = { onTrailingIconClick()  }) {
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