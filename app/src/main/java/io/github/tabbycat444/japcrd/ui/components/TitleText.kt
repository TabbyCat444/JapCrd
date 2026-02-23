package io.github.tabbycat444.japcrd.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * A composable function that displays a title text inside a styled container.
 *
 * @param text The text to display as the title.
 * @param modifier The modifier to be applied to the container displaying the title text.
 */
@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(35.dp))
            .padding(vertical = 10.dp, horizontal = 5.dp)
            .background(MaterialTheme.colorScheme.surfaceContainerLow)
            .width(400.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}