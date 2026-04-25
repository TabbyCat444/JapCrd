package io.github.tabbycat444.japcrd.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import io.github.tabbycat444.japcrd.ui.components.CardItem
import io.github.tabbycat444.japcrd.ui.components.OutlinedText
import io.github.tabbycat444.japcrd.ui.components.TitleText
import io.github.tabbycat444.japcrd.viewmodel.JapCrdViewModel

/**
 * A composable function that represents the flashcard screen for navigating and interacting
 * with flashcards. The screen contains a title, a flashcard to display content, and navigation
 * controls for moving between cards, flipping the card, or shuffling the card deck.
 *
 * @param viewModel The ViewModel used to manage the state and behavior of the flashcard screen,
 * including the current card data, flip state, and card navigation actions.
 */
@Composable
fun FlashcardScreen(viewModel: JapCrdViewModel) {
    val card = viewModel.currCard

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (titleRef, cardRef, controlsRef) = createRefs()

        // ~~~ TITLE ~~~
        Box(
            modifier = Modifier
                .constrainAs(titleRef) {
                    bottom.linkTo(cardRef.top, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            TitleText(viewModel.screenTitle)
        }

        // ~~~ CARD ~~~
        Box(
            modifier = Modifier.constrainAs(cardRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            CardItem(
                textToShow = if (viewModel.isFlipped) card.characterInfo else card.character,
                onFlip = { viewModel.toggleFlip() },
                textStyle = if (viewModel.isFlipped) {
                    MaterialTheme.typography.bodyMedium
                } else {
                    MaterialTheme.typography.displayMedium
                }
            )
        }

        // ~~~ CARD NAVIGATION CONTROLS ~~~
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.constrainAs(controlsRef) {
                top.linkTo(cardRef.bottom, margin = 20.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            val textFamily = MaterialTheme.typography.labelLarge

            Button(
                onClick = { viewModel.prevCard() },
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    OutlinedText(text = "Prev", textFamily = textFamily)
                }
            }
            Button(
                onClick = { viewModel.shuffleDeck() },
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    OutlinedText(text = "Shuffle", textFamily = textFamily)
                }
            }
            Button(
                onClick = { viewModel.nextCard() },
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    OutlinedText(text = "Next", textFamily = textFamily)
                }
            }
        }
    }
}