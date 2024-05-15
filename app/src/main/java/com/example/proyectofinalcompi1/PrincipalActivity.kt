package com.example.proyectofinalcompi1

import abrirArchivo.CreadorCarpetas
import abrirArchivos.AbrirArchivo
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.echo.holographlibrary.Bar
import com.echo.holographlibrary.BarGraph
import com.example.proyectofinalcompi1.AnalizadorLexico.analizadorLexico
import com.example.proyectofinalcompi1.AnalizadorSintactico.AnalizadorSintactico
import com.example.proyectofinalcompi1.Interprete.Graficar
import com.example.proyectofinalcompi1.Interprete.InterpreteGraficadora
import com.example.proyectofinalcompi1.Model.Accion
import com.example.proyectofinalcompi1.Model.Grafica
import com.example.proyectofinalcompi1.databinding.ActivityPrincipalBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.StringReader

class PrincipalActivity : AppCompatActivity() {

    private val Interprete = InterpreteGraficadora()
    private val graficadora = Graficar()


    private val STORAGE_PERMISSION_CODE = 0
    var permisoo:Boolean = false

    private lateinit var  drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView





    @SuppressLint("MissingInflatedId", "WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)


        val rootView = findViewById<View>(android.R.id.content)
        verificarPermisos(rootView)





        //Abrir Archivos


//abrir y cargar archivos
        val AbrirArchivo = AbrirArchivo(this)
        val buttonSelectFile = findViewById<Button>(R.id.buttonOpenFiles)
        buttonSelectFile.setOnClickListener {
            AbrirArchivo.seleccionarArchivo()
            Toast.makeText(applicationContext, "Cargar archivo ", Toast.LENGTH_SHORT).show()
        }





/*

        lateinit var barlist: ArrayList<BarEntry>
        lateinit var barDataSet: BarDataSet
        lateinit var barData: BarData

        val barChart = findViewById<BarChart>(R.id.grafiquita) as BarChart




        barlist= ArrayList()
        barlist.add(BarEntry(1f,10f))
        barlist.add(BarEntry(2f,20f))
        barlist.add(BarEntry(3f,30f))
        barlist.add(BarEntry(4f,40f))
        barlist.add(BarEntry(5f,50f))

        barDataSet = BarDataSet(barlist,"Prueba")
        barData = BarData(barDataSet)

        barChart.data = barData
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS,250)

*/
///exportar la grafica


// Obtener el directorio de archivos de la aplicación interna






        val contenido = findViewById<AppCompatEditText>(R.id.contenidoUsuario)

        val btnAnalizar = findViewById<AppCompatButton>(R.id.analizar)



        btnAnalizar.setOnClickListener{

            Log.i("AngelAPP","Contenido: ${contenido.text.toString()} ")


            compile(contenido.text.toString());





        }
    }


    fun compile(input: String){


        val reader = StringReader(input)
        val analizadorLexico = analizadorLexico(reader)

        val analizadorSintactico = AnalizadorSintactico(analizadorLexico)

        try {
            analizadorSintactico.parse()



            Log.i("AngelAPP", "Objeto traido de java: ")

            val listaAcciones = analizadorSintactico.acciones;

            val listaDeAccionesEncontradas:MutableList<Accion>? = Interprete.Analizar(listaAcciones)



            // Log.i("AngelAPP", "Lista de acciones: $listaAcciones")

            for(Accion in listaAcciones){
                Log.i("AngelAPP", "\n\nAccion: $Accion")
            }

            Log.i("AngelAPP", "\n\n\n\n\nLista de acciones encontradas: ")
            for(Accion in listaDeAccionesEncontradas!!){
                Log.i("AngelAPP", " Accion: $Accion")
            }




            Log.i("AngelAPP", "\n\n\n\n\n\n  "+graficadora.graficar(listaDeAccionesEncontradas))









        } catch (e: Exception) {
            println("Error: $e")
        }




    }


    fun graficarBarras(puntos: ArrayList<Bar>) {










    }



    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isAceptado ->
        if (isAceptado) Toast.makeText(this, "PERMISOS CONCEDIDOS", Toast.LENGTH_SHORT).show()
        else Toast.makeText(this, "PERMISOS DENEGADOS", Toast.LENGTH_SHORT).show()

    }

    private fun verificarPermisos(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(this, "PERMISOS CONCEDIDOS", Toast.LENGTH_SHORT).show()
                    permisoo = true
//                    crearArchivoTXT()
                    val CreadorCarpetas = CreadorCarpetas(this)
                    CreadorCarpetas.crearCarpeta()
//crea la carpeta de la app
                }


                ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) -> {
                    Snackbar.make(
                        view,
                        "ESTE PERMISO ES NECESARIO PARA CREAR EL ARCHIVO TXT",
                        Snackbar.LENGTH_INDEFINITE
                    ).setAction("OK") {
                        requestPermissionLauncher.launch(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    }.show()
                }

                else -> {
                    requestPermissionLauncher.launch(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }
        } else {
//            crearArchivoTXT()
//            crearCarpeta()

        }
    }










}