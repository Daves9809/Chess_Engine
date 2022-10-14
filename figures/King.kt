package com.example.chessengine.figures

import com.example.chessengine.figures.Figure

class King(private var isFigureWhite: Boolean = false) :
    Figure(name = "King", white = isFigureWhite) {

    var isFirstStep: Boolean = true
    var isChecked: Boolean = false

    override fun canMove(endPos: Position): Boolean {
        TODO("Not yet implemented")
    }

    override fun moveFigure(endPos: Position) {
        TODO("Not yet implemented")
    }

    fun isKingUnderAttack():Boolean {
        //TODO
        return true
    }


}