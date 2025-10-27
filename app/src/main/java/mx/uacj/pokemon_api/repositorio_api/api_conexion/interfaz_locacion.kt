package mx.uacj.pokemon_api.repositorio_api.api_conexion

import mx.uacj.pokemon_api.modelos.Locacion
import retrofit2.http.GET
import retrofit2.http.Path

interface InterfazLocacionAPI{
    ///@POST("/pokemon")

    @GET("location/{id}")
    suspend fun descargar_locacion(@Path("id") id: Int): Locacion
}

