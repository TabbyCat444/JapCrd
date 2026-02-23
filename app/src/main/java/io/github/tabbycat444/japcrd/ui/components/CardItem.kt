package io.github.tabbycat444.japcrd.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * A composable function that represents a card displaying text, which can be flipped on tap to show
 * alternative content or trigger an action.
 *
 * @param textToShow The text that will be displayed on the card.
 * @param onFlip A lambda function that is invoked when the card is tapped, typically used to toggle the state.
 * @param textStyle The style to apply to the text displayed on the card.
 */
@Composable
fun CardItem(textToShow: String, onFlip: () -> Unit, textStyle: TextStyle) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow),
        modifier = Modifier.clickable { onFlip() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 30.dp,
            pressedElevation = 2.dp)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(600.dp)
                .width(400.dp)
                .padding(16.dp)
        ) {
            Text(
                text = textToShow,
                style = textStyle,
                textAlign = TextAlign.Center
            )
        }
    }
}

