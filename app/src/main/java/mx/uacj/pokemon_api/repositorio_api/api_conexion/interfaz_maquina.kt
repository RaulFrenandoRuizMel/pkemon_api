package mx.uacj.pokemon_api.repositorio_api.api_conexion

import mx.uacj.pokemon_api.modelos.Locacion
import mx.uacj.pokemon_api.modelos.Maquina
import retrofit2.http.GET
import retrofit2.http.Path

interface InterfazMaquinaAPI{
    ///@POST("/pokemon")

    @GET("machine/{id}")
    suspend fun descargar_maquina(@Path("id") id: Int): Maquina
}