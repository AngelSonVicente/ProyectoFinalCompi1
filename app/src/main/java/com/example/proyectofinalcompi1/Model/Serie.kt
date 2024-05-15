package com.example.proyectofinalcompi1.Model

data class Serie(
    val nombre:String,
    val puntos: MutableList<PuntosSeries>?,
    val puntosSimples: MutableList<DatosGraficaPuntos>?,
    val color: String?,
    val estiloLinea: String?


)
