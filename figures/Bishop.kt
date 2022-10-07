package com.example.chessengine.figures

class Bishop(private var isFigureWhite: Boolean = false) : Figure(white = isFigureWhite) {
    override fun move(endPosition: Position) {
        position = endPosition
    }
}