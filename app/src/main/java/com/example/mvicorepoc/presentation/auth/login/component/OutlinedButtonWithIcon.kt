package com.example.mvicorepoc.presentation.auth.login.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.mvicorepoc.presentation.theme.spacing

@Composable
fun OutlinedButtonWithIcon(modifier: Modifier = Modifier,
                      onButtonClick : () -> Unit,
                     @DrawableRes iconOfButton : Int,
                    @StringRes  cardText : Int

                      ){

    OutlinedButton(
        onClick = { onButtonClick() },
        modifier = modifier
            .fillMaxWidth()
            .padding(top = MaterialTheme.spacing.s24)
            .height(MaterialTheme.spacing.s50),
        shape = RoundedCornerShape(MaterialTheme.spacing.s16)
    ) {
        Image(
            painter = painterResource(iconOfButton),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.s8))
        Text(
            text = stringResource(cardText),
            color =MaterialTheme.colorScheme.onSecondary
        )
    }
}