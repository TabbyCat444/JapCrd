package io.github.tabbycat444.japcrd.data

/**
 * Provides access to predefined card decks and their associated data.
 *
 * This class serves as a repository for managing card decks and retrieving
 * card data based on deck names. Each deck consists of a collection of
 * `CardData` objects representing individual cards.
 */
class CardRepository {
    private val cardDecks = mapOf(
        "Basic Hiragana" to listOf(
            CardData("あ", "a \n \"ah\""),
            CardData("い", "i \n \"ee\""),
            CardData("う", "u \n \"oo\""),
            CardData("え", "e \n \"eh\""),
            CardData("お", "o \n \"oh\""),
            CardData("か", "ka \n \"kah\""),
            CardData("き", "ki \n \"kee\""),
            CardData("く", "ku \n \"koo\""),
            CardData("け", "ke \n \"keh\""),
            CardData("こ", "ko \n \"koh\""),
            CardData("さ", "sa \n \"sah\""),
            CardData("し", "shi \n \"shee\""),
            CardData("す", "su \n \"soo\""),
            CardData("せ", "se \n \"seh\""),
            CardData("そ", "so \n \"soh\""),
            CardData("た", "ta \n \"tah\""),
            CardData("ち", "chi \n \"chee\""),
            CardData("つ", "tsu \n \"tsoo\""),
            CardData("て", "te \n \"teh\""),
            CardData("と", "to \n \"toh\""),
            CardData("な", "na \n \"nah\""),
            CardData("に", "ni \n \"nee\""),
            CardData("ぬ", "nu \n \"noo\""),
            CardData("ね", "ne \n \"neh\""),
            CardData("の", "no \n \"noh\""),
            CardData("は", "ha \n \"hah\""),
            CardData("ひ", "hi \n \"hee\""),
            CardData("ふ", "fu \n \"foo\""),
            CardData("へ", "he \n \"heh\""),
            CardData("ほ", "ho \n \"hoh\""),
            CardData("ま", "ma \n \"mah\""),
            CardData("み", "mi \n \"mee\""),
            CardData("む", "mu \n \"moo\""),
            CardData("め", "me \n \"meh\""),
            CardData("も", "mo \n \"moh\""),
            CardData("や", "ya \n \"yah\""),
            CardData("ゆ", "yu \n \"yoo\""),
            CardData("よ", "yo \n \"yoh\""),
            CardData("ら", "ra \n \"rah\""),
            CardData("り", "ri \n \"lee\""),
            CardData("る", "ru \n \"loo\""),
            CardData("れ", "re \n \"leh\""),
            CardData("ろ", "ro \n \"loh\""),
            CardData("わ", "wa \n \"wah\""),
            CardData("を", "wo \n \"woh\""),
            CardData("ん", "n \n \"nn\"")
        )
    )

    fun getDeckNames(): List<String> = cardDecks.keys.toList()

    fun getDeckCards(deckName: String): List<CardData> {
        return cardDecks[deckName] ?: emptyList()
    }
}