package com.example.miproyectobase.ApiAlumno

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

data class AlumnoInsertRequest(
    val nombre: String,
    val apellido: String,
    val grupo: String,
    val seccion: String,
    val archivo: String
)

data class InsertResponse(
    val success: Boolean,
    val message: String?
)

interface ApiDuocService {
    @GET("apiduoc/consulta.php")
    /*
    * EL METODO @GET PERMITE TRASFORMARLO EN LISTA DE FORMA DIRECTA
    * */
    suspend fun getAlumnos(): List<Alumno>

    @POST("apiduoc/insert.php")
    /*
    * EL BODY = ES LA ESTRUTURA DE LA API , JSON POR EJEMPLI
    * REQUEST = LO QUE SE LE SOLICITA AL SERVIDOR
    * EL InsertResponse = ES LA DATA CLASS DEFINIDA ARRIBA Y DA EL
    * RESULTADO DE SI EL RESULTADO ES CORRECTO O NO
    * */
    suspend fun insertAlumno(@Body request: AlumnoInsertRequest): InsertResponse
}