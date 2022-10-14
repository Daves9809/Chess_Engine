package com.example.chessengine.figures

class Pawn(var isFigureWhite: Boolean = false) :
    Figure(name = "Pawn", white = isFigureWhite) {
    override fun canMove(endPos: Position): Boolean {
        TODO("Not yet implemented")
    }

    override fun moveFigure(endPos: Position) {
        TODO("Not yet implemented")
    }

}