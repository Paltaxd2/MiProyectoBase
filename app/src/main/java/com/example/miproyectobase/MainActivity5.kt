package com.example.miproyectobase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miproyectobase.ApiRegionComuna.CargarRegionComunaAPI

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)

        val spReg:Spinner = findViewById(R.id.sp_Region)
        val spComu:Spinner = findViewById(R.id.sp_Comuna)
        /*
         alt + enter , para importar
         */
        val btnConfirm:Button = findViewById(R.id.btn_confirmar)


        CargarRegionComunaAPI.cargarRegionComuna(this, spReg)

        var result = spReg.selectedItem.toString()
        CargarRegionComunaAPI.cargarRegionComuna2(this, spComu, result)










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}