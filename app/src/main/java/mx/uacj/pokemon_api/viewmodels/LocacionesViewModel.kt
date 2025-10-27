package mx.uacj.pokemon_api.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State
import mx.uacj.pokemon_api.modelos.Locacion
import mx.uacj.pokemon_api.repositorio_api.RepositorioLocaciones
import mx.uacj.pokemon_api.repositorio_api.api_conexion.InterfazLocacionAPI

@HiltViewModel
class LocacionesViewModel @Inject constructor(
    private val repositorio: RepositorioLocaciones,
    private val conexion_server: InterfazLocacionAPI
): ViewModel(){
    private var estado = mutableStateOf("cargando")

    public val locaciones: State<List<Locacion>> = repositorio.locaciones

    init {
        for(indice_locacion in 1..10) {
            descargar_locacion(indice_locacion)
        }
    }

    fun descargar_locacion(id: Int){
        var locacion: Locacion? = null

        viewModelScope.launch {
            locacion = conexion_server.descargar_locacion(id)
            //pokemon_cache = mutableStateOf(pokemon_descargado)
            val lista = repositorio.locaciones.value.toMutableStateList()

            if(locacion != null) {
                lista.add(locacion!!)
            }

            repositorio.locaciones.value = lista
        }

        //return pokemon
    }
}
