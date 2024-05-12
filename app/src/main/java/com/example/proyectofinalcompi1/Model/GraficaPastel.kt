package com.example.proyectofinalcompi1.Model

data class GraficaPastel(
    val simple : Boolean,
    val datos: MutableList<DatosGraficaBarras>,

    val titulo: String?,
    val posicionLeyenda: String?,

    val ifCiclo:IfCondicional?,
    val forCiclo:ForCiclo?,
    val whileCiclo: WhileCiclo?
)
