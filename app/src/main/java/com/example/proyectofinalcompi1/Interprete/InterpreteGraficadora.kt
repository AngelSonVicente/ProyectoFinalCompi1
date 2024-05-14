package com.example.proyectofinalcompi1.Interprete

import com.example.proyectofinalcompi1.Model.*

class InterpreteGraficadora(){


    fun Analizar(listaAcciones:List<Accion>):MutableList<Accion>?{
        val ifInteprete = IFinterprete()
        val forInteprete = ForInterprete()

        val listaDeAccionesEncontradas:MutableList<Accion>? = mutableListOf()


        listaAcciones.forEach{accion ->


            when{
                accion.IFCondicional !=null ->{
                    println("Accion antes del if : $listaAcciones")


                  listaDeAccionesEncontradas?.addAll(ifInteprete.analizar(accion)!!)

                    println("\n\nAccion despues del if : $listaAcciones")



                }
                accion.forCiclo!=null ->{
                    listaDeAccionesEncontradas?.addAll(forInteprete.analizar(accion)!!)


                }
                accion.whileCiclo!=null ->{

                }


                else ->{

                    listaDeAccionesEncontradas?.add(accion)
                }


            }





        }


        return listaDeAccionesEncontradas;
    }



}










