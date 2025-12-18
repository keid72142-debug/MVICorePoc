package com.example.mvicorepoc.presentation.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.mvicorepoc.presentation.theme.spacing

@Composable
fun BaseButton(modifier: Modifier = Modifier,
               onButtonClick: () -> Unit,
               @StringRes  buttonText: Int,


               ) {
    Button(
        modifier = modifier
            .padding(top = MaterialTheme.spacing.s32)
            .fillMaxWidth(),
        onClick = { onButtonClick() },
    ) {
        Text(
            modifier = Modifier.padding(vertical = MaterialTheme.spacing.s8),
            text = stringResource(buttonText),
            style = MaterialTheme.typography.labelLarge,
        )

    }
}