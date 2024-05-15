package abrirArchivos

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.proyectofinalcompi1.PrincipalActivity
import com.example.proyectofinalcompi1.R
import java.io.BufferedReader
import java.io.InputStreamReader


class AbrirArchivo (private val actividad: PrincipalActivity) {


    private val seleccionarArchivoLauncher = actividad.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                leerArchivo(uri)
            }
        }
    }

    public fun seleccionarArchivo() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "gh/plain"
        seleccionarArchivoLauncher.launch(intent)
    }

    private fun leerArchivo(uri: Uri) {
        try {
            val inputStream = actividad.contentResolver.openInputStream(uri)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                stringBuilder.append(line)
                stringBuilder.append("\n")
            }
            inputStream?.close()


        } catch (e: Exception) {
            Toast.makeText(actividad, "Error al leer el archivo", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }



}