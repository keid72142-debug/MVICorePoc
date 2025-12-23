package com.example.mvicorepoc.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvicorepoc.R
import com.example.mvicorepoc.presentation.theme.MVICorePocTheme


@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    backButtonClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable { backButtonClick() },
            painter = painterResource(R.drawable.back),
            contentDescription = null

        )

    }


}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    MVICorePocTheme() {
        TopBar(
            backButtonClick = {}
        )
    }
}