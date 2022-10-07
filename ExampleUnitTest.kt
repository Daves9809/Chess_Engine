package com.example.chessengine

import com.example.chessengine.GameManagement.GameManager
import com.example.chessengine.GameManagement.GameManagerImplementation
import com.example.chessengine.figures.Pawn
import com.example.chessengine.figures.Position
import org.junit.Test


class ExampleUnitTest {

    val gameManager = GameManagerImplementation()

    @Test
    fun checkGameStatus_statusAtStart_GameStatusIsNOT_STARTED() {
        val gameStatus = gameManager.checkGameStatus()
        assert(gameStatus == GameStatus.NOT_STARTED)
    }

    @Test
    fun changeStatus_StatusWhiteWin_GameStatusIsWhiteWin() {
        gameManager.changeGameStatus(GameStatus.WHITE_WIN)
        val gameStatus = gameManager.gameStatus
        assert(gameStatus == GameStatus.WHITE_WIN)
    }

    @Test
    fun resetGame_statusOfGameIsActive() {
        val gameSttt = GameStatus.ACTIVE
        assert(gameManager.gameStatus == GameStatus.ACTIVE)
    }

    @Test
    fun winGame_whiteWin_statusOfGameIsWhiteWIN() {
        val gameStatus = gameManager.winGame(Player(whiteSide = true))
        assert(gameStatus == GameStatus.WHITE_WIN)
    }

    @Test
    fun resign_blackResign_GameStatusIsResignationBlack() {
        val gameStatus = gameManager.resign(Player(whiteSide = false))
        assert(gameStatus == GameStatus.RESIGNATION_BLACK)
    }

    @Test
    fun moveFigure_toAvailablePosition_FigureMoved() {
        //Pawn is child of abstract class Figure
        val startPosition = Position(3, 1)
        val destination = Position(3,3)
        val figure = Pawn()
        figure.position = startPosition
        gameManager.moveFigure(figure = figure, destination)
        assert(figure.position == destination)
    }

    @Test
    fun showPossibleMoves_GameStatusIsStartOfGame_PawnHas2Positions() {
        val startPosition = Position(1, 1)
        val pawn = Pawn()
        pawn.position = startPosition
        val availableMoves =
            listOf<Position>(
                Position(startPosition.x, startPosition.y + 1),
                Position(startPosition.x, startPosition.y + 2)
            )
        assert(gameManager.showPossibleMoves(figure = pawn) == availableMoves)
    }

    @Test
    fun killFigure(){
        val killingFigure = Pawn(isFigureWhite = true)
        killingFigure.position = Position(2,3)
        val killedFigure = Pawn(isFigureWhite = false)
        killedFigure.position = Position(3,4)
        gameManager.killFigure(killingFigure,killedFigure)
        assert(!killedFigure.alive)
    }


}