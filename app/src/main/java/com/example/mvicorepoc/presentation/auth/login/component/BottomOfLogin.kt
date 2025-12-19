package com.example.mvicorepoc.presentation.auth.login.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
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
fun BottomOfLogin(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.s24)
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(R.string.or),
                color = MaterialTheme.colorScheme.surfaceVariant
            )

            HorizontalDivider(modifier = Modifier.weight(1f))
        }
        OutlinedButtonWithIcon(
            onButtonClick = { /*TODO*/ },
            iconOfButton = R.drawable.google,
            cardText = R.string.continue_with_google
        )
        OutlinedButtonWithIcon(
            onButtonClick = { /*TODO*/ },
            iconOfButton = R.drawable.facebook,
            cardText = R.string.continue_with_facebook
        )
        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    top = MaterialTheme.spacing.s32
                ),

            ) {
            Text(
                "Don’t have an account? ",
                color = MaterialTheme.colorScheme.surfaceVariant
            )

            Text(
                text = stringResource(R.string.sign_up),
                style =
                    MaterialTheme.typography.labelMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(
                        Alignment.CenterVertically
                    )
                    .clickable { /*TODO*/ }
            )
        }
    }
}