package blackjack

class Player(name: String, cards: Cards) : Gamer(name, cards) {
    fun addMoreCards(selectValue: String, card: Card): Boolean {
        return when {
            selectValue == NO -> true
            cards.isGraterThanWinScore(card) -> throw IllegalArgumentException("21을 초과하여 카드를 입력할 수 없습니다.")
            else -> {
                cards.addCard(card)
                false
            }
        }
    }

    companion object {
        const val NO = "n"
    }
}