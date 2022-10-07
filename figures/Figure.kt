package com.example.chessengine.figures

abstract class Figure(
    var position: Position = Position(0,0),
    var selected: Boolean = false,
    var alive: Boolean = true,
    var white:Boolean = false
): Movement{
    fun select(){
        selected = !selected
    }
}