package io.github.tabbycat444.japcrd.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

/**
 * Displays text with an outlined style and a filled style overlaid, creating a visually distinct effect.
 *
 * @param text The text content to be displayed.
 * @param textFamily The text style to apply to the text, including font family, size, and weight.
 * @param modifier A [Modifier] to apply to the text components.
 * @param textAlign The alignment of the text within its container. Defaults to [TextAlign.Center].
 * @param outlineWidth The width of the outline around the text. Defaults to 2.0f.
 */
@Composable
fun OutlinedText(
    text: String,
    textFamily: TextStyle,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    outlineWidth: Float = 1.5f,
) {
    // ~~~ TEXT OUTLINE ~~~
    Text(
        text = text,
        style = textFamily.copy(
            color = MaterialTheme.colorScheme.onTertiary,
            drawStyle = Stroke(width = outlineWidth),
        ),
        textAlign = textAlign,
        modifier = modifier,
    )

    // ~~~ FILL TEXT ~~~
    Text(
        text = text,
        style = textFamily.copy(
            color = MaterialTheme.colorScheme.onPrimary,
        ),
        textAlign = textAlign,
        modifier = modifier,
    )
}