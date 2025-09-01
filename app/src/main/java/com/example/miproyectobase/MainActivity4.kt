package com.example.miproyectobase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// IMPORT PACKAGE
import com.example.miproyectobase.utils.OpMatematicas

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val edNumero1: EditText = findViewById(R.id.ed_numero1)
        val edNumero2: EditText = findViewById(R.id.ed_numero2)
        val btnCalcular:Button = findViewById(R.id.btn_calcular)
        val txResultado: TextView = findViewById(R.id.tx_resultado)
        val spOperaciones: Spinner = findViewById(R.id.sp_operaciones)

        // Creaemos nuestro primer Array
        val menuSPoperaciones = listOf("Sumar", "Restar", "Multiplicar", "Dividir")

        // Vamos a
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            menuSPoperaciones
        )

        spOperaciones.adapter = adapter

        var str_op_select = spOperaciones.selectedItem.toString()

        btnCalcular.setOnClickListener{
            var calcN1: Int = edNumero1.text.toString().toIntOrNull() ?:0
            var calcN2: Int = edNumero2.text.toString().toIntOrNull() ?:0

            if (str_op_select == "Sumar"){
                var resultadoOP: Int = OpMatematicas.sumar(calcN1, calcN2)
                txResultado.text = resultadoOP.toString()

            } else if (str_op_select == "Restar"){
                var resultadoOP: Int = OpMatematicas.restar(calcN1, calcN2)
                txResultado.text = resultadoOP.toString()

            } else if (str_op_select == "Dividir"){
                var resultadoOP: Int = OpMatematicas.dividir(calcN1, calcN2)
                txResultado.text = resultadoOP.toString()

            } else if (str_op_select == "Multiplicar"){
                var resultadoOP: Int = OpMatematicas.multiplicar(calcN1, calcN2)
                txResultado.text = resultadoOP.toString()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}