package blackjack.domain

class CardDeck {
    val cards: Cards = makeCards().shuffleCards()

    fun pop(): Card {
        return cards.pop()
    }

    private fun makeCards(): MutableList<Card> {
        val cards = CardSuit.values().flatMap { cardShape ->
            Denomination.values().map { cardNumber ->
                Card(cardShape, cardNumber)
            }
        }.toMutableList()

        return cards
    }
}

fun MutableList<Card>.shuffleCards(): Cards = Cards(this.apply { shuffle() })