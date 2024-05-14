package com.example.proyectofinalcompi1.Interprete

import com.example.proyectofinalcompi1.Model.Accion
import com.example.proyectofinalcompi1.Model.PasoFor

class ForInterprete {

    fun analizar(accion:Accion):MutableList<Accion>?{


        val Interprete = InterpreteGraficadora()

        val listaDeAccionesEncontradas:MutableList<Accion>? = mutableListOf()

        if(isOperableNumero(accion)){

            val valorInicial= accion.forCiclo!!.valorIncial.toInt();
            val valorFinal= accion.forCiclo!!.valorfinal.toInt();

            if(accion.forCiclo?.paso == PasoFor.incremento){
                for(i in  valorInicial until valorFinal ){

                    listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.forCiclo.instrucciones!!)!!)



                }

            }
            if(accion.forCiclo?.paso == PasoFor.decremento){
                for(i in valorInicial downTo valorInicial ){

                    listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.forCiclo.instrucciones!! )!!)

                }


            }




        }








        return  listaDeAccionesEncontradas;
    }

    fun isOperableNumero(accion:Accion):Boolean{
        val valor1: Int? = accion.forCiclo?.valorIncial?.toIntOrNull()
        val valor2: Int? = accion.forCiclo?.valorfinal
            ?.toIntOrNull()

        if(valor1==null){
            //buscar valor en la tabla de simbolos
        }
        if(valor2==null){
            //buscar valor en la tabla de simbolos
        }

        if(valor1!=null && valor2!=null){

            return true;
        }
        return false
    }

}