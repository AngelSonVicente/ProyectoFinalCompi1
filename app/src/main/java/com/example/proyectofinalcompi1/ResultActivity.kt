package com.example.proyectofinalcompi1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val Resultado = findViewById<TextView>(R.id.Resultado)

    val resultadoAnalisi: String=    intent.extras?.getString("resultadoAnalisis").orEmpty()

        Resultado.text=resultadoAnalisi

    }
}