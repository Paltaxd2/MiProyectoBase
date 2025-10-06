package com.example.miproyectobase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miproyectobase.funciones.InsertarAlumnosAPI

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)


        val edTxtName : EditText = findViewById(R.id.ed_nombreAlumno)
        val edTxtApellido : EditText = findViewById(R.id.ed_apellidoAlumno)
        val spGrupo : Spinner = findViewById(R.id.sp_grupo)
        val spSeccion : Spinner = findViewById(R.id.sp_seccion)
        val btnTomarFoto : Button = findViewById(R.id.btn_tomarFoto)
        val btnGuardarNose : Button = findViewById(R.id.btn_guardarAlumno)

        // Lista para el Spinner de grupos
        val gupos = listOf(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20"
        )

        val secciones = listOf(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20"
        )

        val menuGrupo = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            gupos).apply {
                setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        val menuSeccion = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            secciones).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        spGrupo.adapter = menuGrupo

        spSeccion.adapter = menuSeccion

        btnGuardarNose.setOnClickListener{
            InsertarAlumnosAPI.insertarAlumno(
                owner = this,
                context = this,
                nombre = edTxtName.text.toString(),
                apellido = edTxtApellido.text.toString(),
                grupo = spGrupo.selectedItem.toString(),
                seccion = spSeccion.selectedItem.toString(),
                archivoBytes = null,
                onSuccess = {
                    println("termino insert correcto")
                    Toast.makeText(this
                        , "guardado"
                        , Toast.LENGTH_SHORT)
                },
                onError = {
                    println("termino insert incorrecto")
                    Toast.makeText(this, "NO guardado", Toast.LENGTH_SHORT)
                }
            )
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}