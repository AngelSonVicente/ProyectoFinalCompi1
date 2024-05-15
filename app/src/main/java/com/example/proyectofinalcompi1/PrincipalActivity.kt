package com.example.proyectofinalcompi1

import abrirArchivo.CreadorCarpetas
import abrirArchivo.CrearGrafico
import abrirArchivos.AbrirArchivo
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.StrictMode
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
import androidx.core.content.FileProvider
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


    var listaAccionesEncontradas: MutableList<Accion>? = null

    private val STORAGE_PERMISSION_CODE = 0
   val   PICK_FOLDER_WRITE_CODE =7
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

        //exportarWeb("grafici.hml")
        val exportarHTML = findViewById<Button>(R.id.buttonExportarW)
        exportarHTML.setOnClickListener{




            if(listaAccionesEncontradas!=null){

                crearArchivoTXT(graficadora.graficar(listaAccionesEncontradas!!), "Graficas");


            }else{

                Toast.makeText(applicationContext, "No hay graficas que exportar ", Toast.LENGTH_SHORT).show()

            }





        }









        val butonn =  findViewById<Button>(R.id.buttonVerG)
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

        butonn.setOnClickListener{view->
            val CrearGrafico = CrearGrafico(barChart, this)
            CrearGrafico.saveChartToGallery()
        }

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


        listaAccionesEncontradas=null

        val reader = StringReader(input)
        val analizadorLexico = analizadorLexico(reader)

        val analizadorSintactico = AnalizadorSintactico(analizadorLexico)

        try {
            analizadorSintactico.parse()

            val ErrorAnalisis:String? = analizadorSintactico.errores



            Log.i("AngelAPP", "Objeto traido de java: ")

            if(ErrorAnalisis==null) {

                var listaAcciones = analizadorSintactico.acciones;


                listaAccionesEncontradas = Interprete.Analizar(listaAcciones)


                listaAccionesEncontradas?.forEach { accion ->
                    Log.i("Encontrado", "$accion ")



                }

                // Log.i("AngelAPP", "Lista de acciones: $listaAcciones")

                for (Accion in listaAcciones) {
                    Log.i("AngelAPP", "\n\nAccion: $Accion")
                }

                Log.i("AngelAPP", "\n\n\n\n\nLista de acciones encontradas: ")
                for (Accion in listaAcciones!!) {
                    Log.i("AngelAPP", " Accion: $Accion")
                }


                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("resultadoAnalisis", "No hay errores!!")
                startActivity(intent)






                Log.i(
                    "AngelAPP",
                    "\n\n\n\n\n\n  " + graficadora.graficar(listaAcciones)
                )


            }


                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("resultadoAnalisis", ErrorAnalisis)
                startActivity(intent)






        } catch (e: Exception) {
            println("Error: $e")
        }







    }







    fun exportarWeb(nombreHtml:String){
        val btnNuevoFile = findViewById<Button>(R.id.buttonExportarW)
        btnNuevoFile.setOnClickListener { view ->
//            crearArchivoTXT("prueba de htmldasfadsfsfadsfasd")


// Ruta del archivo HTML en el almacenamiento interno de la aplicación
            val filePath = "${getExternalFilesDir(null)}/grafici.html"
            val file = File(filePath)

            if (file.exists()) {
                val uri = FileProvider.getUriForFile(this, "${packageName}.fileprovider", file)
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setDataAndType(uri, "text/html")
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

                // Esto es necesario para evitar errores con FileUriExposedException
                val builder = StrictMode.VmPolicy.Builder()
                StrictMode.setVmPolicy(builder.build())

                startActivity(intent)
            } else {
                Log.i("", "No existeee")
            }

        }

    }








    private fun crearArchivoTXT(texto: String, nombreArchivo: String ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val context = applicationContext
            val archivo = File(context.getExternalFilesDir(null), "$nombreArchivo.html")
            try {
                if (!archivo.exists()) {
                    archivo.createNewFile()
                    Toast.makeText(context, "ARCHIVO HTML CREADO", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Archivo HTML CREADO", Toast.LENGTH_SHORT).show()
                }
                archivo.writeText(texto) // Escribir el texto en el archivo
            } catch (e: IOException) {
                Toast.makeText(context, "Error al crear el archivo TXT", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        } else {
            val path = Environment.getExternalStorageDirectory().absolutePath + "/grafici.txt"
            val archivo = File(path)
            try {
                if (!archivo.exists()) {
                    archivo.createNewFile()
                    Toast.makeText(this, "ARCHIVO HTML CREADO", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "ARCHIVO HTML CREADO", Toast.LENGTH_SHORT).show()
                }
                archivo.writeText(texto) // Escribir el texto en el archivo
            } catch (e: IOException) {
                Toast.makeText(this, "Error al crear el archivo HTML", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
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
                    crearCarpeta()
//                    val CreadorCarpetas = CreadorCarpetas(this)
//                    CreadorCarpetas.crearCarpeta()
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


    public fun crearCarpeta() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val context = this
            val carpeta = File(context.getExternalFilesDir(null), "mi_carpeta")
            try {
                if (!carpeta.exists()) {
                    carpeta.mkdir()
                    Toast.makeText(context, "CARPETA CREADA", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Simon ya existe", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(context, "Error al crear la carpeta", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        } else {
            val path = Environment.getExternalStorageDirectory().absolutePath + "/mi_carpeta"
            val carpeta = File(path)
            try {
                if (!carpeta.exists()) {
                    carpeta.mkdir()
                    Toast.makeText(this, "CARPETA CREADA", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "La carpeta ya existe", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error al crear la carpeta", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }





    }










