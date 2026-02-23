package io.github.tabbycat444.japcrd.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import io.github.tabbycat444.japcrd.data.CardData
import io.github.tabbycat444.japcrd.data.CardRepository

/**
 * ViewModel for managing flashcard data and state in the Japanese learning application.
 *
 * This ViewModel provides UI state and behavior for navigating and interacting with
 * Japanese card decks. It handles deck selection, card navigation, card flipping, and
 * shuffling functionality. The data is sourced from a `CardRepository` which provides
 * relevant card information based on the selected deck.
 *
 * Responsibilities:
 * - Maintain the current deck name and associated card data.
 * - Provide state variables representing the current position within the deck and the flip state of cards.
 * - Enable actions such as shuffling, switching decks, navigating cards, and toggling flip states.
 */
class JapCrdViewModel : ViewModel() {
    private val repository = CardRepository()

    var currDeck by mutableStateOf("Basic Hiragana")
        private set

    var cardDataList by mutableStateOf(repository.getDeckCards(currDeck))
        private set

    fun shuffleDeck() {
        cardDataList = cardDataList.shuffled()
        currIndex = 0
        isFlipped = false
    }

    fun setDeck(deckName: String) {
        currDeck = deckName
        cardDataList = repository.getDeckCards(deckName)
        currIndex = 0
        isFlipped = false
    }

    // ~~~ UI STATE ~~~
    var currIndex by mutableIntStateOf(0)
        private set

    var isFlipped by mutableStateOf(false)
        private set

    val screenTitle = "Basic Hiragana"

    val currCard: CardData
        get() = cardDataList[currIndex]

    // ~~~ LOGIC ~~~
    fun toggleFlip() {
        isFlipped = !isFlipped
    }

    fun nextCard() {
        isFlipped = false
        currIndex = (currIndex + 1) % cardDataList.size
    }

    fun prevCard() {
        isFlipped = false
        currIndex = (currIndex - 1 + cardDataList.size) % cardDataList.size
    }
}