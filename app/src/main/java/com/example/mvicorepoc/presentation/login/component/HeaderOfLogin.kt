package com.example.mvicorepoc.presentation.login.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.mvicorepoc.R
import com.example.mvicorepoc.presentation.theme.spacing

@Composable
fun HeaderOfLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.padding(end = MaterialTheme.spacing.s8),
            painter = painterResource(id = R.drawable.login_icon),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.logoipsum),
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold
            ),
        )
    }
    Text(
        modifier = Modifier.padding(top = MaterialTheme.spacing.s32),
        text = stringResource(R.string.sign_in_to_your_account),
        style = MaterialTheme.typography.displaySmall.copy(
            fontWeight = FontWeight.Bold
        ),
    )
    Text(
        modifier = Modifier.padding(top = MaterialTheme.spacing.s32),
        text = stringResource(R.string.enter_your_email_and_password_to_log_in),
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.surfaceVariant,

        )

}