package com.example.proyectofinalcompi1.Model

data class Accion(
    val graficaBarras: GraficaBarras?,
    val graficaLineas: GraficaLineas?,
    val graficaPastel: GraficaPastel?,
    val graficaPuntos: GraficaPuntos?,
    val tarjetaInformacion: TarjetaInformacion?,
    val IFCondicional:IfCondicional?,
    val whileCiclo: WhileCiclo?,
    val forCiclo: ForCiclo?




) {
    override fun toString(): String {
        return "Accion(graficaBarras=$graficaBarras, graficaLineas=$graficaLineas, graficaPastel=$graficaPastel, graficaPuntos=$graficaPuntos, tarjetaInformacion=$tarjetaInformacion, IFCondicional=$IFCondicional, whileCiclo=$whileCiclo, forCiclo=$forCiclo)"
    }
}




