package com.example.mvicorepoc.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mvicorepoc.R
import com.example.mvicorepoc.presentation.theme.MVICorePocTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

}

@Composable
fun LoginContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
            .padding(16.dp),
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = modifier.padding(horizontal = 16.dp),
                painter = painterResource(id = R.drawable.login_icon),
                contentDescription = null
            )
            Text(text = stringResource(R.string.logoipsum),
                style = MaterialTheme.typography.labelLarge)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    MVICorePocTheme {
        LoginContent()
    }
}