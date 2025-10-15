package com.example.miproyectobase

import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miproyectobase.camaara.CameraController

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main7)

        val imgFoto : ImageView = findViewById(R.id.img_ImagenFoto)
        val btnTomFotoForm : Button = findViewById(R.id.btn_FormFotoTomarFoto)
        val btnGuardFotoForm : Button = findViewById(R.id.btn_FormFotoGuardarFoto)

        val resultImagen = CameraController.takePhoto() ?: return








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}