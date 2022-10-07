package com.example.chessengine.GameManagement

import com.example.chessengine.GameStatus
import com.example.chessengine.Player
import com.example.chessengine.figures.Bishop
import com.example.chessengine.figures.Figure
import com.example.chessengine.figures.Position

class GameManagerImplementation: GameManager {

    var gameStatus = GameStatus.NOT_STARTED

    override fun changeGameStatus(gameStatus: GameStatus) {
        TODO("Not yet implemented")
    }

    override fun checkGameStatus(): GameStatus {
        TODO("Not yet implemented")
    }

    override fun resetGame() {
        TODO("Not yet implemented")
    }

    override fun winGame(player: Player): GameStatus {
        TODO("Not yet implemented")
    }

    override fun resign(player: Player): GameStatus {
        TODO("Not yet implemented")
    }

    fun chooseFigure(figure: Figure) {
        TODO("Not yet implemented")
    }

    override fun moveFigure(figure: Figure, endPosition: Position) {
        TODO("Not yet implemented")
    }

    override fun showPossibleMoves(figure: Figure): List<Position> {
        TODO("Not yet implemented")
    }

    //set figure to !alive
    override fun killFigure(killingFigure: Figure, figureToKill: Figure) {
        TODO("Not yet implemented")
    }

}