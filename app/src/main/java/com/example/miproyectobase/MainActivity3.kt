package com.example.miproyectobase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val btnRegistro:Button = findViewById(R.id.btn_registro)
        val edNombre:EditText = findViewById(R.id.ed_nombre)
        val edTelefono:EditText = findViewById(R.id.ed_telefono)
        val edFechaNac:EditText= findViewById(R.id.ed_fechaNac)

        var nombre = "Rafael"
        var telefono = "12341234"
        var fecha = "01/01/01"

        btnRegistro.setOnClickListener{
            if (edNombre.text.toString() != "Rafael" ||
                edTelefono.text.toString() != "12341234" ||
                edFechaNac.text.toString() != "01/01/01"){

                //toast                    (this, variable o texto, duracion)
                val toast = Toast.makeText(this, "Nombre o Telefono o Fecha Incorrectos", Toast.LENGTH_SHORT) // in Activity
                //desplegar el popup
                toast.show()
            }else{

            }

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}