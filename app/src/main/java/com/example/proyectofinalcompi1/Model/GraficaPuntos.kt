package com.example.proyectofinalcompi1.Model

data class GraficaPuntos(
    val simple : Boolean,
    val datos : MutableList<DatosGraficaPuntos>,

    val titulo: String?,
    val xLabel: String?,
    val yLabel: String?,

    val ifCiclo:IfCondicional?,
    val forCiclo:ForCiclo?,
    val whileCiclo: WhileCiclo?




)
