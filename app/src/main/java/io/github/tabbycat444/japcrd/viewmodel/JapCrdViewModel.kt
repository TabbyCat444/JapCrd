package io.github.tabbycat444.japcrd.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.github.tabbycat444.japcrd.data.CardData
import io.github.tabbycat444.japcrd.data.CardRepository

/**
 * ViewModel class for managing the state and behavior of a Japanese flashcard deck.
 *
 * The JapCrdViewModel is responsible for managing the currently selected deck of flashcards,
 * tracking the current card and its flip state, and providing navigation and deck-related
 * operations such as shuffling and switching decks. It communicates with a repository to
 * load deck data.
 *
 * Primary responsibilities:
 * - Load and manage card data for the selected deck.
 * - Track the current card index and flip state for display purposes.
 * - Handle operations like flipping cards, navigating between cards, and shuffling the deck.
 */
class JapCrdViewModel : ViewModel() {
    private val repository = CardRepository()

    var currDeck by mutableStateOf("All Hiragana")
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

    val screenTitle = "All Hiragana"

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