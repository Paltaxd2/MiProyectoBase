package com.example.miproyectobase.ApiRegionComuna

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Objeto que conecta la aplicacion con el webservices
 * usa corutinas para que las llamadas se ejecuten en segundo plano asi
 * no bloquea el hilo principal
 */
object RegionComunaRepository {

    suspend fun fetchRegionComuna(): Result<List<RegionComuna>> = withContext(Dispatchers.IO) {
        try {
            Result.success(ApiDuocRegionComuna.service.getRegionComuna())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}