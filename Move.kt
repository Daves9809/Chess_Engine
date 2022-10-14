package com.example.chessengine

import com.example.chessengine.figures.Figure
import com.example.chessengine.figures.Position

class Move(
    val figure: Figure,
    val attackedFigure: Figure?,
    val startPos: Position,
    val endPos: Position
) {
    fun makeMove(){

    }
}