package io.github.tabbycat444.japcrd.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.tabbycat444.japcrd.ui.theme.OutlinedText

/**
 * A composable function that displays a title text within a styled surface. The surface includes
 * rounded corners, shadow elevation, and tonal elevation to create a polished appearance.
 *
 * @param text The text to be displayed as the title.
 * @param modifier A Modifier to apply additional styling or layout parameters to the surface.
 */
@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(10.dp)

    Surface(
        modifier = Modifier
            .width(300.dp)
            .then(modifier),
        shape = shape,
        color = MaterialTheme.colorScheme.surfaceContainerLow,
        tonalElevation = 2.dp,
        shadowElevation = 30.dp
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(bottom = 5.dp)
        ) {
            val textFamily = MaterialTheme.typography.headlineLarge

            OutlinedText(text = text, textFamily = textFamily)

        }
    }
}