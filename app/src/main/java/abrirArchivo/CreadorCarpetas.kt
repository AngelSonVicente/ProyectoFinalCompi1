package abrirArchivo

import android.os.Build
import android.os.Environment
import android.widget.Toast
import com.example.proyectofinalcompi1.PrincipalActivity
import java.io.File


class CreadorCarpetas(private val actividad: PrincipalActivity) {

    public fun crearCarpeta() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val context = actividad
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
                    Toast.makeText(actividad, "CARPETA CREADA", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(actividad, "La carpeta ya existe", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(actividad, "Error al crear la carpeta", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }


}