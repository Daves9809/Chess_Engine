package com.example.chessengine

import com.example.chessengine.GameManagement.GameManager
import com.example.chessengine.figures.*
import org.junit.Before
import org.junit.Test


class ExampleUnitTest {
    lateinit var board: Board
    lateinit var gameStatus: GameStatus
    @Before
    fun initialize (){
        board = Board()
        gameStatus = board.gameStatus
    }

    //tests related to gameStatus
    @Test
    fun checkGameStatus_statusAtStart_GameStatusIsNOT_STARTED() {
        assert(board.checkGameStatus() == GameStatus.NOT_STARTED)
    }

    @Test
    fun changeStatus_StatusWhiteWin_GameStatusIsWhiteWin() {
        board.changeGameStatus(GameStatus.WHITE_WIN)
        val gameStatus = board.gameStatus
        assert(gameStatus == GameStatus.WHITE_WIN)
    }

    @Test
    fun resetGame_statusOfGameIsActive() {
        board.resetGame()
        val gameStatus = board.gameStatus
        assert(gameStatus == GameStatus.ACTIVE)
    }

    @Test
    fun winGame_whiteWin_statusOfGameIsWhiteWIN() {
        val gameStatus = board.winGame(Player(whiteSide = true))
        assert(gameStatus == GameStatus.WHITE_WIN)
    }

    @Test
    fun resign_blackResign_GameStatusIsResignationBlack() {
        val gameStatus = board.resign(Player(whiteSide = false))
        assert(gameStatus == GameStatus.RESIGNATION_BLACK)
    }

    //Board initialization related code

    @Test
    fun initBoard_isPositionsAndFiguresCreated_true(){
        board.initPositions()
        board.initFigures()

        assert(board.positions.size == 8)
        for (position in board.positions) {
            assert(position.size == 8)
        }

        assert(board.getPosition('E',8).figure?.name == "King")
        assert(board.getPosition('E',8).figure?.white == false)
        assert(board.getPosition('A',8).figure?.name == "Rook")
        assert(board.getPosition('A',8).figure?.white == false)

        assert(board.getPosition('E',1).figure?.name == "King")
        assert(board.getPosition('E',1).figure?.white == true)
        assert(board.getPosition('A',1).figure?.name == "Rook")
        assert(board.getPosition('A',1).figure?.white == true)
    }

    //test related to moves

    @Test
    fun moveFigure_toAvailablePosition_FigureMoved() {
        //Pawn is child of abstract class Figure
        val startPosition = Position('A', 7)
        val destination = Position('A',5)
        val figure = Pawn()
        figure.position = startPosition
        board.moveFigure(figure = figure, destination)
        assert(figure.position == destination)
    }
    @Test
    fun moveFigure_blackwrongMove_WhiteWinGame(){
        val pawn = Pawn(isFigureWhite = false)
        pawn.position = Position('A',7)
        board.moveFigure(pawn,Position('D',4))
        assert(gameStatus == GameStatus.WHITE_WIN)
    }

    @Test
    fun showPossibleMoves_GameStatusIsStartOfGame_PawnHas2Positions() {
        val startPosition = Position('D', 2)
        val pawn = Pawn()
        pawn.position = startPosition
        val availableMoves =
            listOf<Position>(
                Position(startPosition.x, startPosition.y + 1),
                Position(startPosition.x, startPosition.y + 2)
            )
        assert(board.showPossibleMoves(figure = pawn) == availableMoves)
    }

    @Test
    fun isKingUnderAttack_twoScenarios_trueAndFalse(){
        val rook = Rook(isFigureWhite = true)
        val king = King(isFigureWhite = false)

        rook.position = Position('A',3)
        king.position = Position('A',5)
        assert(king.isKingUnderAttack())

        rook.position = Position('D',4)
        king.position = Position('E',5)
        assert(!king.isKingUnderAttack())
    }

    @Test
    fun isEndOfGame_blackKingMate_WhiteWin(){
        val queen = Queen(isFigureWhite = true)
        val pawn = Pawn(isFigureWhite = true)
        val king = King(isFigureWhite = false)

        queen.position = Position('G',5)
        pawn.position = Position('H',4)
        king.position = Position('G',6)

        assert(board.checkGameStatus() == GameStatus.WHITE_WIN)
    }

    @Test
    fun killFigure_pawnWhiteIsKiller_BlackIsNotAlive(){
        val pawnWhite = Pawn(isFigureWhite = true)
        val pawnBlack = Pawn(isFigureWhite = false)

        pawnWhite.position = Position('D',5)
        pawnBlack.position = Position('C',4)
        board.moveFigure(pawnWhite, pawnBlack.position)
        assert(!pawnBlack.alive)
    }

    @Test
    fun playedMoves_FourMovesAndKill_CorrectAnnotation(){
        val knightWhite = Knight(isFigureWhite = true)
        val knightBlack = Knight(isFigureWhite = false)

        knightWhite.moveFigure(Position('C',3))
        knightBlack.moveFigure(Position('F',6))
        knightWhite.moveFigure(Position('D',5))
        knightBlack.moveFigure(Position('F',6))

        assert(board.playedMoves == listOf<String>(
            "${knightWhite.name}c3",
            "${knightBlack.name}f6",
            "${knightWhite.name}d5",
            "${knightWhite.name}xf6",
        ))
    }

}