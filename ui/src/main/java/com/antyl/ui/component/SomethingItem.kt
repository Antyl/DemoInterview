package com.antyl.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.antyl.ui.theme.Pink80

@Composable
fun SomethingItem(
    name: String,
    parameter: String,
    onItemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 50.dp)
            .padding(horizontal = 10.dp)
            .background(color = Pink80, shape = RoundedCornerShape(10.dp))
            .clickable(onClick = onItemClick),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(start = 10.dp)
                .weight(1f),
            text = name
        )
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(end = 10.dp)
                .weight(1f),
            text = parameter,
            textAlign = TextAlign.End
        )
    }
}