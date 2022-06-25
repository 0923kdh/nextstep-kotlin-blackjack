package blackjack.domain.winning

import blackjack.domain.player.Player
import blackjack.domain.score.PlayerScore

class WinningStat(
    playerScores: List<PlayerScore>,
    dealerScore: PlayerScore,
) {
    private val scores: List<PlayerScore> = playerScores
    private val dealerScore: Int = dealerScore.score
    private val dealer: Player = dealerScore.player
    val result = playerGameResult()

    fun playerGameResult(): List<PlayerGameResult> {
        return scores.map {
            PlayerGameResult(
                it.player,
                playerWinningState(it)
            )
        }
    }

    private fun playerWinningState(playerScore: PlayerScore): WinningState {
        return when {
            dealerBust() -> WinningState.DEALER_BUST
            playerBust(playerScore) -> WinningState.PLAYER_BUST
            playerBlackJack(playerScore) -> WinningState.PLAYER_BLACKJACK
            playerBlackJack(playerScore) && dealerBlackJack() -> WinningState.PLAYER_TIE
            dealerScore < playerScore.score -> WinningState.PLAYER_WIN
            dealerScore == playerScore.score -> WinningState.PLAYER_TIE
            else -> WinningState.PLAYER_LOOSE
        }
    }

    private fun dealerBust(): Boolean = dealerScore > BLACK_JACK_SCORE

    private fun dealerBlackJack(): Boolean = (dealerScore == BLACK_JACK_SCORE && dealer.cards.size == FIRST_TURN_CARDS_SIZE)

    private fun playerBust(playerScore: PlayerScore): Boolean = playerScore.score > BLACK_JACK_SCORE

    private fun playerBlackJack(playerScore: PlayerScore): Boolean = (playerScore.score == BLACK_JACK_SCORE && playerScore.player.cards.size == 2)

    companion object {
        private const val BLACK_JACK_SCORE = 21
        private const val FIRST_TURN_CARDS_SIZE = 2
    }
}