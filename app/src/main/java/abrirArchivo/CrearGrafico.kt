package abrirArchivo

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Environment
import android.util.Log
import android.widget.Toast
import com.example.proyectofinalcompi1.PrincipalActivity
import com.github.mikephil.charting.charts.BarChart
import java.io.IOException
import java.io.File
import java.io.FileOutputStream



class CrearGrafico (val chart: BarChart, val ac: PrincipalActivity){

    public fun saveChartToGallery() {
        // Crear un bitmap de la gráfica
        val bitmap = Bitmap.createBitmap(chart.width, chart.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        chart.draw(canvas)

        // Guardar el bitmap en la galería

        val file = File(ac.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "chart.png")
        Log.i("", file.absolutePath)
        try {
            FileOutputStream(file).use { fos ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
                Toast.makeText(ac, "Gráfico guardado en la galería", Toast.LENGTH_SHORT).show()
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(ac, "Error al guardar el gráfico", Toast.LENGTH_SHORT).show()
        }
    }


}