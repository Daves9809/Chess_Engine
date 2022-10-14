package com.example.chessengine.GameManagement

import com.example.chessengine.GameStatus
import com.example.chessengine.Player
import com.example.chessengine.figures.Figure
import com.example.chessengine.figures.Position

interface GameManager {

    fun initPositions()

    fun initFigures()

    fun getPosition(x: Char, y: Int): Position

    fun replacePawn(figure: Figure)

    fun checkGameStatus(): GameStatus

    fun changeGameStatus(gameStatus: GameStatus)

    fun resetGame()

    fun winGame(player: Player): GameStatus

    fun resign(player: Player): GameStatus

    fun moveFigure(figure: Figure, endPosition: Position)

    fun showPossibleMoves(figure: Figure): List<Position>

    fun killFigure(killingFigure: Figure, figureToKill: Figure)

}