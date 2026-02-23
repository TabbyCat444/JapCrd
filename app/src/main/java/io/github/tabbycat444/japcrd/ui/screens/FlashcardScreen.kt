package io.github.tabbycat444.japcrd.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.tabbycat444.japcrd.viewmodel.JapCrdViewModel
import io.github.tabbycat444.japcrd.ui.components.CardItem
import io.github.tabbycat444.japcrd.ui.components.TitleText

/**
 * A composable function that displays the flashcard screen, which includes a title and a flashcard
 * UI component with navigation controls for flipping and switching cards.
 *
 * @param viewModel The ViewModel instance providing the data and state for the flashcard screen,
 * including the list of cards, UI behaviors like flipping, and navigation between cards.
 */
@Composable
fun FlashcardScreen(viewModel: JapCrdViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.25f),
            contentAlignment = Alignment.Center
        ) {
            TitleText(viewModel.screenTitle)
        }

        FlashCard(
            viewModel = viewModel,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

/**
 * A composable function that represents a flashcard UI component capable of displaying text,
 * flipping the card to show alternate content, and navigating through a deck of cards.
 *
 * The flashcard includes navigation buttons for flipping to the previous card, shuffling the
 * deck to change the order of cards, and moving to the next card in the deck.
 *
 * @param viewModel The ViewModel instance managing the state and logic for the flashcard, including the current card data,
 * navigation logic, and flip state.
 * @param modifier Modifier to be applied to the root composable of the flashcard for styling and layout adjustments.
 */
@Composable
fun FlashCard(viewModel: JapCrdViewModel, modifier: Modifier = Modifier) {
    val card = viewModel.currCard

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        CardItem(
            textToShow = if (viewModel.isFlipped) card.characterInfo else card.character,
            onFlip = { viewModel.toggleFlip() },
            textStyle = if (viewModel.isFlipped) {
                MaterialTheme.typography.bodyLarge
            } else {
                MaterialTheme.typography.displayLarge
            }
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Button(onClick = { viewModel.prevCard() }) { Text("Prev") }
            Button(onClick = { viewModel.shuffleDeck() }) { Text("Shuffle") }
            Button(onClick = { viewModel.nextCard() }) { Text("Next") }
        }
    }
}

