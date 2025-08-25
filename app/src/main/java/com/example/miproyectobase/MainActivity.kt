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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Declaramos variables con los elementos layout
        // nombre de variable:tipo de variable = findView, R.id.nombre del ID
        val edUsername:EditText = findViewById(R.id.ed_username)
        val edPassword:EditText = findViewById(R.id.ed_password)
        val btnLogin:Button = findViewById(R.id.btn_login)

        var defaultUsr = "ch.munozs@profesor.duoc.cl"
        var defaultPasswd = "admin123"

        // Accion sobre el boton
        btnLogin.setOnClickListener{
            if(edUsername.text.toString() == defaultUsr  &&
                edPassword.text.toString() == defaultPasswd){
                // Intent , es abrir una ventana o inicializar un nuevo elemento
                val nuevaVentana = Intent(this, MainActivity2::class.java)
                nuevaVentana.putExtra("pUsuario", edUsername.text.toString())
                startActivity(nuevaVentana)

            }else{
                val toast = Toast.makeText(this, "Usuario o Contraseña Incorrectos", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}