package com.example.proyectofinalcompi1.Interprete

import com.example.proyectofinalcompi1.Model.Accion
import kotlin.random.Random

class Graficar {

    fun graficar(listaAcciones: List<Accion>):String{
        var contenido  = StringBuilder()

        contenido.append("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "  \n" +
                "    <title>Gráfico de Barras</title>\n" +
                "    <!-- Incluir la biblioteca de Chart.js -->\n" +
                "    <script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n" +
                "</head>\n" +
                "<body>")
        contenido.append(generarCanva(listaAcciones)).append("<script>")
        contenido.append(generarScript(listaAcciones))
        contenido.append("</script></body></html>")













        return contenido.toString()
    }


   fun generarCanva(listaAcciones: List<Accion>):String{

       val alto: Int = 400
       val ancho: Int = 800

       var contenido  = StringBuilder()



       var i :Int =0

       listaAcciones.forEach{ accion ->


           contenido.append("<canvas id=\"").append("grafica${i}\" width=\"$ancho\" height=\"$alto\"></canvas>\n")




           i++


       }


       return  contenido.toString()
   }

    fun generarScript(listaAcciones: List<Accion>):String{
        var i: Int = 0

        var contenido = StringBuilder()


        listaAcciones.forEach { accion ->




            /*

 var ctx = document.getElementById('myChart').getContext('2d');

                   // Configurar los datos de la gráfica
        var data = {
            labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo'],
            datasets: [{
                label: 'Datos',
                data: [12, 19, 3, 5, 2],
                backgroundColor: 'rgba(255, 99, 132, 0.2)', // Color de fondo de las barras
                borderColor: 'rgba(255, 99, 132, 1)', // Color del borde de las barras
                borderWidth: 1
            }]
        };

            */


            contenido.append(" var ctx = document.getElementById('grafica${i}').getContext('2d');")
            contenido.append(" var data={\n ")




            when{
                accion.graficaBarras !=null ->{


                    if(accion.graficaBarras.simple){
                        contenido.append("labels:[")

                        //mete todos los datos de las categorias
                        accion.graficaBarras.datos.forEach {dato ->
                            contenido.append(" '${dato.category}' , ")
                        }


                        contenido.append("],\n datasets:[{ label: 'Categorias' , data:[  ")


                        //mete todos los datos de los valores
                        accion.graficaBarras.datos.forEach { dato ->
                            contenido.append(" '${dato.value}' , ")
                        }

                        contenido.append("],  backgroundColor: 'rgb(46, 204, 113 )', \n" +
                                "            }]\n" +
                                "        }; ")


                        //configuracion de la grafica
                        contenido.append(" var options = {\n" +
                                "       responsive: false, \n" +
                                "   \n" +
                                "          maintainAspectRatio: false, \n" +
                                "    aspectRatio: 1, \n" +
                                "  \n" +
                                "            scales: {\n" +
                                "                y: {\n" +
                                "                    beginAtZero: true // Iniciar el eje Y desde cero\n" +
                                "                }\n" +
                                "            }\n" +
                                "        };\n" +
                                "        \n" +
                                "        var myChart = new Chart(ctx, {\n" +
                                "            type: 'bar', \n" +
                                "            data: data,\n" +
                                "            options: options\n" +
                                "        });")

                    }




                }

                accion.graficaPastel !=null ->{

                    if(accion.graficaPastel.simple){

                        contenido.append("labels:[")

                        accion.graficaPastel.datos.forEach {dato ->
                            contenido.append(" '${dato.category}' , ")
                        }

                        contenido.append("],\n datasets:[{ label: 'Datos' , data:[ ")
                        //mete todos los datos de los valores
                        accion.graficaPastel?.datos?.forEach { dato ->
                            contenido.append(" '${dato.value}' , ")
                        }

                        contenido.append("], backgroundColor: [")


                        //genera un color diferente a cada pedazo de pastel
                        accion.graficaPastel.datos.forEach{accion ->



                            contenido.append("'rgb(").append(generarNumeroAleatorio()).append(",").append(generarNumeroAleatorio()).append(",").append(generarNumeroAleatorio()).append(")',")


                        }

                        contenido.append("], }]\n" +
                                "        };\n" +
                                "\n" +
                                "       \n" +
                                "       \n" +
                                "        var options = {\n" +
                                "    responsive: false, \n" +
                                "    maintainAspectRatio: false, \n" +
                                "    aspectRatio: 1 \n" +
                                "};\n" +
                                "\n" +
                                "\n" +
                                "        \n" +
                                "        \n" +
                                "        var myPieChart = new Chart(ctx, {\n" +
                                "            type: 'pie',\n" +
                                "            data: data, \n" +
                                "            options: options \n" +
                                "        });")









                    }


                }
                accion.graficaPuntos!=null ->{
                    if(accion.graficaPuntos.simple){





                        contenido.append("\n datasets:[{ \n label: 'Datos' , data:[ ")

                        accion.graficaPuntos.datos.forEach { dato ->

                            contenido.append("{x: ${dato.x} , y: ${dato.y}},")

                        }

                        contenido.append("], }]\n" +
                                "};\n" +
                                "\n" +

                                "        var options = {\n" +
                                "        responsive: false, \n" +
                                "            maintainAspectRatio: false,\n" +
                                "         \n" +
                                "            scales: {\n" +
                                "                x: {\n" +
                                "                    type: 'linear', \n" +
                                "                    position: 'bottom'\n" +
                                "                },\n" +
                                "                y: {\n" +
                                "                    beginAtZero: true \n" +
                                "                }\n" +
                                "            }\n" +
                                "        };\n" +
                                "\n" +
                                "       \n" +
                                "        var myScatterChart = new Chart(ctx, {\n" +
                                "            type: 'scatter', \n" +
                                "            data: data, \n" +
                                "            options: options \n" +
                                "        });")





                    }












                }
                accion.graficaLineas != null -> {

                    if (accion.graficaLineas.simple) {


                        contenido.append(
                            "\n" +
                                    " datasets:["
                        )


                        accion.graficaLineas.series.forEach { serie ->


                            contenido.append("{ label: '${serie.nombre}' , data:[ ")

                            serie.puntosSimples?.forEach { dato ->

                                contenido.append("{x: ${dato.x} , y: ${dato.y}},")

                            }

                            contenido.append("],borderColor: 'rgb(")
                                .append(generarNumeroAleatorio()).append(",")
                                .append(generarNumeroAleatorio()).append(",")
                                .append(generarNumeroAleatorio()).append(")',")

                            contenido.append("},")


                        }


                        contenido.append(
                            "]\n" +
                                    "        };\n" +
                                    "\n" +
                                    "        // Configuración de la gráfica de líneas\n" +
                                    "        var options = {\n" +
                                    "            responsive: false, \n" +
                                    "            maintainAspectRatio: false, \n" +
                                    "            scales: {\n" +
                                    "                x: {\n" +
                                    "                    type: 'linear',\n" +
                                    "                    position: 'bottom' \n" +
                                    "                },\n" +
                                    "                y: {\n" +
                                    "                    beginAtZero: true\n" +
                                    "                }\n" +
                                    "            }\n" +
                                    "        };\n" +
                                    "\n" +
                                    "       \n" +
                                    "        var myLineChart = new Chart(ctx, {\n" +
                                    "            type: 'line',\n" +
                                    "            data: data, \n" +
                                    "            options: options\n" +
                                    "        });"
                        )


                    }

                }











                else ->{


                }


            }









            i++
        }

        return  contenido.toString()
    }













    fun generarNumeroAleatorio(): Int {
        return Random.nextInt(256)



}
}