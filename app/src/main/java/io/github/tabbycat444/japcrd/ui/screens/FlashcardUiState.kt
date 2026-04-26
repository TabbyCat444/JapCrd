package io.github.tabbycat444.japcrd.ui.screens

import io.github.tabbycat444.japcrd.data.CardData

/**
 * Represents the UI state for a flashcard application screen.
 *
 * This class encapsulates the data necessary to render and manage the state
 * of the flashcard screen, including the list of deck names, the currently
 * selected deck, and details about the cards within the current deck.
 *
 * @property deckNames A list of deck names available in the application.
 * @property currDeck The name of the currently selected flashcard deck.
 * @property cardDataList A list of card data belonging to the current deck.
 * @property currIndex The index of the flashcard currently being displayed.
 * @property isFlipped Indicates whether the current flashcard is flipped to show additional details.
 */
data class FlashcardUiState(
    val deckNames: List<String> = emptyList(),
    val currDeck: String = "",
    val cardDataList: List<CardData> = emptyList(),
    val currIndex: Int = 0,
    val isFlipped: Boolean = false
) {
    val screenTitle: String
        get() = currDeck

    val currCard: CardData?
        get() = cardDataList.getOrNull(currIndex)
}