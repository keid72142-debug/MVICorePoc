package com.example.mvicorepoc.presentation.auth.signup.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.mvicorepoc.R
import com.example.mvicorepoc.presentation.theme.spacing

@Composable
fun BottomOfSignup(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    top = MaterialTheme.spacing.s32
                ),

            ) {
            Text(
                "Already have an account? ",
                color = MaterialTheme.colorScheme.surfaceVariant
            )

            Text(
                text = stringResource(R.string.login),
                style =
                    MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(
                        Alignment.CenterVertically
                    )
                    .clickable { onLoginClick() }
            )
        }
    }
}