package com.example.miproyectobase.ApiRegionComuna

import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

object CargarRegionComunaAPI {

    /** Carga alumnos del API y los pinta en el ListView indicado. */
    fun cargarRegionComuna(owner: LifecycleOwner, spinner: Spinner) {
        owner.lifecycleScope.launch {
            val res = RegionComunaRepository.fetchRegionComuna()

            res.onSuccess { region ->
                if (region.isEmpty()) {
                    Toast.makeText(
                        spinner.context,
                        "Sin datos desde el servicio",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                val datos = region
                            .distinctBy { it.region }
                            .map { a ->
                            //"ID  : ${a.id}\n" +
                            //"COMUNA   : ${a.comuna}\n" +
                            "REGION : ${a.region}"
                }

                spinner.adapter = ArrayAdapter(
                    spinner.context,
                    android.R.layout.simple_list_item_1,
                    datos
                )

                android.util.Log.d("WS_region_comuna", "items=${region.size}")
            }.onFailure { e ->
                android.util.Log.e("WS_region_comuna", "falló", e)
                Toast.makeText(
                    spinner.context,
                    "Error al cargar: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}