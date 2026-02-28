package io.github.tabbycat444.japcrd.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import io.github.tabbycat444.japcrd.ui.theme.OutlinedText

/**
 * A composable function that displays a card with text content. The card can be flipped using a click action.
 *
 * @param textToShow The text to display within the card.
 * @param textStyle The text style to apply to the displayed text.
 * @param onFlip A callback function to be invoked when the card is clicked.
 */
@Composable
fun CardItem(
    textToShow: String,
    textStyle: TextStyle,
    onFlip: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
        modifier = Modifier.clickable { onFlip() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 30.dp,
            pressedElevation = 2.dp
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(400.dp)
                .width(300.dp)
                .padding(16.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                OutlinedText(text = textToShow, textFamily = textStyle)
            }
        }
    }
}

