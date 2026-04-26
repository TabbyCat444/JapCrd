package io.github.tabbycat444.japcrd.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import io.github.tabbycat444.japcrd.ui.components.CardItem
import io.github.tabbycat444.japcrd.ui.components.OutlinedText
import io.github.tabbycat444.japcrd.ui.components.TitleText
import io.github.tabbycat444.japcrd.viewmodel.JapCrdViewModel
import kotlinx.coroutines.launch

/**
 * A composable function that renders the flashcard screen. Displays the current flashcard,
 * allows navigation between flashcards, and provides functionality to switch decks through a drawer menu.
 *
 * @param viewModel The ViewModel that provides the state and logic for managing
 * the flashcard screen, including the current card, deck names, flipping actions,
 * and navigation between cards.
 */
@Composable
fun FlashcardScreen(viewModel: JapCrdViewModel) {
    val state = viewModel.uiState
    val card = state.currCard
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    if (card == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No cards available",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        return
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            ModalDrawerSheet {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, top = 12.dp, end = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Decks",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    IconButton(
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Close deck menu"
                        )
                    }
                }

                state.deckNames.forEachIndexed { index, deckName ->
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = deckName,
                                style = MaterialTheme.typography.bodySmall
                            )
                        },
                        selected = deckName == state.currDeck,
                        onClick = {
                            viewModel.setDeck(deckName)
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )

                    if (index < state.deckNames.lastIndex) {
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 24.dp),
                            color = MaterialTheme.colorScheme.outlineVariant
                        )
                    }
                }
            }
        }
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (menuRef, titleRef, cardRef, controlsRef) = createRefs()

            // ~~~ HAMBURGER MENU ~~~
            IconButton(
                onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                },
                modifier = Modifier.constrainAs(menuRef) {
                    top.linkTo(parent.top, margin = 32.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Open deck menu"
                )
            }

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
                TitleText(state.screenTitle)
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
                    textToShow = if (state.isFlipped) card.characterInfo else card.character,
                    onFlip = { viewModel.toggleFlip() },
                    textStyle = if (state.isFlipped) {
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
}