package com.antyl.ui.component

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.ErrorView(
    text: String
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 200.dp)
            .padding(horizontal = 32.dp)
            .align(Alignment.TopCenter),
        textAlign = TextAlign.Center,
        text = text
    )
}