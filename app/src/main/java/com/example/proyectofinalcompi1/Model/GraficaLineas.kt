package com.example.proyectofinalcompi1.Model

data class GraficaLineas(
    val simple:Boolean,
    val series:MutableList<Serie>,

    val titulo: String?,
    val xLabel:String?,
    val yLabel:String?,

    val ifCiclo:IfCondicional?,
    val forCiclo:ForCiclo?,
    val whileCiclo: WhileCiclo?





)
