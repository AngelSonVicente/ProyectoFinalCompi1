package CrearGraficas

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Environment
import android.util.Log
import android.widget.Toast
import com.example.proyectofinalcompi1.PrincipalActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class CrearGraficoPastel(val chart: PieChart, val ac: PrincipalActivity) {

    public fun saveChartToGallery(nombre:String) {
        // Crear un bitmap de la gráfica
        val bitmap = Bitmap.createBitmap(chart.width, chart.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        chart.draw(canvas)

        // Guardar el bitmap en la galería

        val file = File(ac.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "$nombre.png")
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