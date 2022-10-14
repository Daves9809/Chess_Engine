package com.example.chessengine.figures

import com.example.chessengine.Move

abstract class Figure(
    var name: String,
    var position: Position = Position(),
    var alive: Boolean = true,
    var white:Boolean = false,
    var id: Int = 0,
    var possibleMoves: List<Move> = mutableListOf()

){

    abstract fun canMove(endPos: Position): Boolean

    abstract fun moveFigure(endPos: Position)
}