package com.example.proyectofinalcompi1

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)

        val contenido = findViewById<AppCompatEditText>(R.id.contenidoUsuario)

        val btnAnalizar = findViewById<AppCompatButton>(R.id.analizar)
        btnAnalizar.setOnClickListener{

            Log.i("AngelAPP","Contenido: ${contenido.text.toString()} ")

        }



    }
}