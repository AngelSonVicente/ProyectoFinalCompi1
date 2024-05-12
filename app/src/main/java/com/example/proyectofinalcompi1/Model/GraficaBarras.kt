package com.example.proyectofinalcompi1.Model

data class GraficaBarras(

    val simple : Boolean,
    val datos: MutableList<DatosGraficaBarras>,

    val titulo: String?,
    val xLabel: String?,
    val yLabel: String?,

    val ifCiclo:IfCondicional?,
    val forCiclo:ForCiclo?,
    val whileCiclo: WhileCiclo?,





)