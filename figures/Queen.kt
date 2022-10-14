package com.example.chessengine.figures

import com.example.chessengine.figures.Figure

class Queen(private var isFigureWhite: Boolean = false) :
    Figure(name = "Queen", white = isFigureWhite) {
    override fun canMove(endPos: Position): Boolean {
        TODO("Not yet implemented")
    }

    override fun moveFigure(endPos: Position) {
        TODO("Not yet implemented")
    }

}