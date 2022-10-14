package com.example.chessengine

import android.util.Log
import com.example.chessengine.GameManagement.GameManager
import com.example.chessengine.figures.Figure
import com.example.chessengine.figures.Position

class Board: GameManager {
    val playedMoves: List<Move> = mutableListOf()
    lateinit var positions: Array<Array<Position>>
    var gameStatus: GameStatus = GameStatus.NOT_STARTED

    init {
        initPositions()
        initFigures()
    }

    override fun initPositions() {
        TODO("Not yet implemented")
    }

    override fun initFigures() {
        TODO("Not yet implemented")
    }

    override fun getPosition(x: Char, y: Int): Position {
        TODO("Not yet implemented")
    }

    override fun replacePawn(figure: Figure) {
        TODO("Not yet implemented")
    }

    override fun checkGameStatus(): GameStatus {
        TODO("Not yet implemented")
    }

    override fun changeGameStatus(gameStatus: GameStatus) {
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

    override fun moveFigure(figure: Figure, endPosition: Position) {
        TODO("Not yet implemented")
    }

    override fun showPossibleMoves(figure: Figure): List<Position> {
        TODO("Not yet implemented")
    }

    override fun killFigure(killingFigure: Figure, figureToKill: Figure) {
        TODO("Not yet implemented")
    }


}
