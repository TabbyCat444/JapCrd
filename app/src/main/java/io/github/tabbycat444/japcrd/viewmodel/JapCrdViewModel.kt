package io.github.tabbycat444.japcrd.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.github.tabbycat444.japcrd.data.CardRepository
import io.github.tabbycat444.japcrd.ui.screens.FlashcardUiState

/**
 * JapCrdViewModel is responsible for managing the state and behavior of a flashcard
 * application that includes decks of cards for the purpose of learning Japanese.
 * It interacts with a repository to retrieve card data and provides operations
 * such as deck selection, card flipping, shuffling, and navigation between cards.
 *
 * @constructor Initializes the view model with a default or provided CardRepository instance.
 *
 * @property repository The data source used for accessing deck and card information.
 *
 * @property uiState The observable state of the view model, which includes the current deck,
 *                   the list of cards in the deck, the current card index, and whether the card
 *                   is flipped or not.
 */
class JapCrdViewModel(
    private val repository: CardRepository = CardRepository()
) : ViewModel() {

    var uiState by mutableStateOf(createInitialState())
        private set

    private fun createInitialState(): FlashcardUiState {
        val deckNames = repository.getDeckNames()
        val initialDeck = deckNames.firstOrNull().orEmpty()

        return FlashcardUiState(
            deckNames = deckNames,
            currDeck = initialDeck,
            cardDataList = repository.getDeckCards(initialDeck),
            currIndex = 0,
            isFlipped = false
        )
    }

    fun shuffleDeck() {
        if (uiState.cardDataList.isEmpty()) return

        uiState = uiState.copy(
            cardDataList = uiState.cardDataList.shuffled(),
            currIndex = 0,
            isFlipped = false
        )
    }

    fun setDeck(deckName: String) {
        val cardList = repository.getDeckCards(deckName)
        if (cardList.isEmpty()) return

        uiState = uiState.copy(
            currDeck = deckName,
            cardDataList = cardList,
            currIndex = 0,
            isFlipped = false
        )
    }

    fun toggleFlip() {
        uiState = uiState.copy(
            isFlipped = !uiState.isFlipped
        )
    }

    fun nextCard() {
        if (uiState.cardDataList.isEmpty()) return

        uiState = uiState.copy(
            currIndex = (uiState.currIndex + 1) % uiState.cardDataList.size,
            isFlipped = false
        )
    }

    fun prevCard() {
        if (uiState.cardDataList.isEmpty()) return

        uiState = uiState.copy(
            currIndex = (uiState.currIndex - 1 + uiState.cardDataList.size) % uiState.cardDataList.size,
            isFlipped = false
        )
    }
}