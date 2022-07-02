package blackjack.domain.card

class Deck(cardShuffle: CardShuffle) {
    private val _cards: MutableList<Card> = cardShuffle.getCards().toMutableList()

    fun deal(): Card {
        return _cards.removeFirst()
    }

    fun isEmptyCard(): Boolean = _cards.isEmpty()

    val cards: List<Card>
        get() = _cards.toList()
}