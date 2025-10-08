package com.example.miproyectobase.ApiAlumno

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Objeto que conecta la aplicacion con el webservices
 * usa corutinas para que las llamadas se ejecuten en segundo plano asi
 * no bloquea el hilo principal
 */
object AlumnosRepository {


    /*
    * EL BODY = ES LA ESTRUTURA DE LA API , JSON POR EJEMPLI
    * REQUEST = LO QUE SE LE SOLICITA AL SERVIDOR
    * SUSPEND = PERMITE EJECUTAR EL PROCESO SIN PAUSAR EL CODIGO
    * RESULT = DEUELVE UN POSITIVO O FALSO SEGUN SI SE PUDO REALIZAR LA ACCION O NO
    * Introduce local variable = VA SI O SI
    * .service = ES UNA VARIABLE DEFINIDA EN ApiDuocClient
    * */
    suspend fun fetchAlumnos(): Result<List<Alumno>> = withContext(Dispatchers.IO) {
        try {
            Result.success(ApiDuocClient.service.getAlumnos())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun insertAlumno(request: AlumnoInsertRequest): Result<InsertResponse> = withContext(Dispatchers.IO) {
        try {
            Result.success(ApiDuocClient.service.insertAlumno(request))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}