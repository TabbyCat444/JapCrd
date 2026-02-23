package io.github.tabbycat444.japcrd.data

/**
 * Represents the data associated with a card in the application.
 *
 * This class is used to encapsulate information about a particular card,
 * such as the character displayed on the card and its related information.
 *
 * @property character The main character or symbol displayed on the card.
 * @property characterInfo Additional information or description related to the character.
 */
data class CardData(
    val character: String,
    val characterInfo: String
)
