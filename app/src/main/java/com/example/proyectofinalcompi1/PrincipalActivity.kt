package com.example.proyectofinalcompi1

import CrearGraficas.CrearGraficoBarras
import CrearGraficas.CrearGraficoPastel
import abrirArchivos.AbrirArchivo
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.StrictMode
import android.print.PrintAttributes
import android.print.pdf.PrintedPdfDocument
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.drawerlayout.widget.DrawerLayout
import com.example.proyectofinalcompi1.AnalizadorLexico.analizadorLexico
import com.example.proyectofinalcompi1.AnalizadorSintactico.AnalizadorSintactico
import com.example.proyectofinalcompi1.Interprete.Graficar
import com.example.proyectofinalcompi1.Interprete.InterpreteGraficadora
import com.example.proyectofinalcompi1.Model.Accion
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import java.io.File


import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
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




    private lateinit var textViewLineNumber: TextView
    private lateinit var editText: EditText

    @SuppressLint("MissingInflatedId", "WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)


            textViewLineNumber = findViewById(R.id.editText)
            editText = findViewById(R.id.contenidoUsuario)

            // Agregar un listener para detectar cambios en el texto del EditText
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    // No es necesario hacer nada antes de que cambie el texto
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    // No es necesario hacer nada mientras cambia el texto
                }

                override fun afterTextChanged(s: Editable?) {
                    // Actualizar el número de línea
                    updateLineAndColumnNumber()
                }
            })












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









        val butonn =  findViewById<Button>(R.id.crearArchivo)




///exportar la grafica


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
// Obtener el directorio de archivos de la aplicación interna

        butonn.setOnClickListener{view->

            crearArchivohg(" ArchivoNuevo", this, applicationContext)


        }




        val contenido = findViewById<EditText>(R.id.contenidoUsuario)

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


        graficarPNG()



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



    fun graficarPNG(){

        listaAccionesEncontradas?.forEach { accion ->

            var i:Int=0

            i++
            when {

                accion.graficaBarras!=null ->{

                    lateinit var barlist: ArrayList<BarEntry>
                    lateinit var barDataSet: BarDataSet
                    lateinit var barData: BarData

                    val barChart = findViewById<BarChart>(R.id.grafiquita) as BarChart




                    barlist= ArrayList()


                    accion.graficaBarras.datos.forEach { dato ->
                        barlist.add(BarEntry(dato.value.toFloat(),dato.value.toFloat()))

                    }



                    barDataSet = BarDataSet(barlist,"Datos")
                    barData = BarData(barDataSet)

                    barChart.data = barData
                    barDataSet.setColors(ColorTemplate.JOYFUL_COLORS,250)

                    val CrearGrafico = CrearGraficoBarras(barChart, this)
                    CrearGrafico.saveChartToGallery("Grafica$i")






                }

                accion.graficaPastel!=null ->{

                    lateinit var PieEntries: ArrayList<PieEntry>

                     PieEntries = ArrayList()

                    accion.graficaPastel.datos.forEach { dato ->
                        PieEntries.add(PieEntry(dato.value.toFloat()))

                    }

                    // Crear un conjunto de datos para el gráfico de pastel
                    val dataSet = PieDataSet(PieEntries, "Datos de ejemplo")
                    dataSet.colors = listOf(Color.RED, Color.GREEN, Color.BLUE)

                    // Crear el gráfico de pastel
                    val pieChart = findViewById<PieChart>(R.id.pieChart)
                    pieChart.setUsePercentValues(true)
                    pieChart.description.isEnabled = false

                    // Crear un objeto PieData y establecer el conjunto de datos
                    val pieData = PieData(dataSet)
                    pieChart.data = pieData


                    val CrearGrafico = CrearGraficoPastel(pieChart, this)
                    CrearGrafico.saveChartToGallery("GraficaPastel$i")






                }


            }




        }


    }




      val REQUEST_CODE_SELECT_DIRECTORY = 123

    private fun crearArchivohg( nombreArchivo: String, activity: Activity, context: Context) {


        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
        intent.addCategory(Intent.CATEGORY_DEFAULT)
        try {
            activity.startActivityForResult(Intent.createChooser(intent, "Selecciona una carpeta"), REQUEST_CODE_SELECT_DIRECTORY)
        } catch (e: Exception) {
            Toast.makeText(context, "Error al abrir el selector de directorios", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SELECT_DIRECTORY && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                val rutaSeleccionada = File(uri.path ?: "")
                val textoHTML = "Contenido del archivo HTML"

                if (rutaSeleccionada.isDirectory) {
                    val nombreArchivo = "nombre_archivo"
                    val archivo = File(rutaSeleccionada, "$nombreArchivo.html")

                    try {
                        if (!archivo.exists()) {
                            archivo.createNewFile()
                            Toast.makeText(this, "ARCHIVO HTML CREADO", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Archivo HTML CREADO", Toast.LENGTH_SHORT).show()
                        }
                        archivo.writeText(textoHTML) // Escribir el texto en el archivo
                    } catch (e: IOException) {
                        Toast.makeText(this, "Error al crear el archivo HTML", Toast.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }
                }
            }
        }
    }










    private fun updateLineAndColumnNumber() {
        // Calcular el número de línea y columna en el EditText
        val lineNumber = editText.layout.getLineForOffset(editText.selectionStart) + 1
        val columnNumber = editText.selectionStart - editText.layout.getLineStart(lineNumber - 1) + 1

        // Formatear el número de línea y columna como una cadena
        val lineAndColumnText = "Linea: $lineNumber , Col: $columnNumber"

        // Actualizar el TextView con el número de línea y columna formateado
        textViewLineNumber.text = lineAndColumnText
    }









    }















