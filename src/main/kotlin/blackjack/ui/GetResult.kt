package blackjack.ui

import blackjack.entity.Card
import blackjack.entity.Player

object GetResult {

    fun informGameStart(names: List<String>) {
        println(names.toString() + "에게 " + "2장을 나누었습니다.")
    }

    fun printPlayerStatus(player: Player) {
        val cardStatus = getCardStatus(player)
        println(player.name + "카드: " + cardStatus)
    }

    fun printPlayerStatusWithResult(player: Player) {
        val cardStatus = getCardStatus(player)
        println(player.name + "카드: " + cardStatus + " - 결과: " + player.getWalletSum())
    }

    fun getCardStatus (player: Player): String {
        return player.getWalletCards().joinToString(JOIN_SEPARATOR) { card :Card -> card.getNumberValue().toString() + card.getShapeValue() }
    }

    private const val JOIN_SEPARATOR = ", "
}