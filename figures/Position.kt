package com.example.chessengine.figures

import com.example.chessengine.Board

data class Position(
    var x:Char = 'A',
    var y: Int = 0 ,
    val color: String = "",
    val figure: Figure? = null,
    val board: Board? = null,
    val id: String =""
    )
