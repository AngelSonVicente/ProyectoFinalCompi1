package com.example.proyectofinalcompi1.Interprete

import com.example.proyectofinalcompi1.Model.Accion
import com.example.proyectofinalcompi1.Model.Comparador

class IFinterprete {


    fun analizar(accion: Accion):MutableList<Accion>?{
        val Interprete = InterpreteGraficadora()

        val listaDeAccionesEncontradas:MutableList<Accion>? = mutableListOf()

        //aca verificamos si no hay otros bloques internos
        if(accion.IFCondicional?.booolean !=null){

            //si solo tien un boolean y es true, se tiene que ejecutar su bloque

            if(accion.IFCondicional.booolean==true){


                listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesIf!!)!!)



            }else{
                if(accion.IFCondicional.instruccionesElse!=null){
                    listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesElse!!)!!)


                }

            }


        }else{


            when(accion.IFCondicional?.comparador){
                Comparador.IGUAL_IGUAL ->{
                    if(accion.IFCondicional.valor1 == accion.IFCondicional.valor2){
                        listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesIf!!)!!)

                    }else{
                        listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesElse!!)!!)

                    }
                }




                Comparador.DIFERENTE -> {
                    if(accion.IFCondicional.valor1 != accion.IFCondicional.valor2){
                        listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesIf!!)!!)

                    }else{
                        listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesElse!!)!!)

                    }

                }





                Comparador.MAYOR_QUE -> {

                    if (isOperableNumero(accion)){
                        if(accion.IFCondicional.valor1!!.toInt()> accion.IFCondicional.valor2!!.toInt()){
                            listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesIf!!)!!)


                        }else{
                            listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesElse!!)!!)

                        }


                    }


                }


                Comparador.MENOR_QUE -> {
                    if (isOperableNumero(accion)){
                        if(accion.IFCondicional.valor1!!.toInt()< accion.IFCondicional.valor2!!.toInt()){
                            listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesIf!!)!!)


                        }else{
                            listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesElse!!)!!)

                        }


                    }


                }


                Comparador.MENOR_IGUAL -> {
                    if (isOperableNumero(accion)){
                        if(accion.IFCondicional.valor1!!.toInt()<= accion.IFCondicional.valor2!!.toInt()){
                            listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesIf!!)!!)


                        }else{
                            listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesElse!!)!!)

                        }


                    }



                }
                Comparador.MAYOR_IGUAL -> {
                    if (isOperableNumero(accion)){
                        if(accion.IFCondicional.valor1!!.toInt()>= accion.IFCondicional.valor2!!.toInt()){
                            listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesIf!!)!!)


                        }else{
                            listaDeAccionesEncontradas?.addAll(Interprete.Analizar(accion.IFCondicional.instruccionesElse!!)!!)

                        }


                    }

                }
                null -> {
                    //null
                }
                }
            }




        return listaDeAccionesEncontradas
        }






    }
    fun isOperableNumero(accion:Accion):Boolean{
        val valor1: Int? = accion.IFCondicional?.valor1?.toIntOrNull()
        val valor2: Int? = accion.IFCondicional?.valor2?.toIntOrNull()

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




