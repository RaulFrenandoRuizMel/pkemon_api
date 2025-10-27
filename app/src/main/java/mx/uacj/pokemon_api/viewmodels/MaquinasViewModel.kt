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
import mx.uacj.pokemon_api.modelos.Maquina
import mx.uacj.pokemon_api.repositorio_api.RepositorioLocaciones
import mx.uacj.pokemon_api.repositorio_api.RepositorioMaquinas
import mx.uacj.pokemon_api.repositorio_api.api_conexion.InterfazLocacionAPI
import mx.uacj.pokemon_api.repositorio_api.api_conexion.InterfazMaquinaAPI

@HiltViewModel
class MaquinasViewModel @Inject constructor(
    private val repositorio: RepositorioMaquinas,
    private val conexion_server: InterfazMaquinaAPI
): ViewModel(){
    private var estado = mutableStateOf("cargando")

    public val maquinas: State<List<Maquina>> = repositorio.maquinas

    init {
        for(indice_maquina in 1..10) {
            descargar_maquina(indice_maquina)
        }
    }

    fun descargar_maquina(id: Int){
        var maquina: Maquina? = null

        viewModelScope.launch {
            maquina = conexion_server.descargar_maquina(id)
            //pokemon_cache = mutableStateOf(pokemon_descargado)
            val lista = repositorio.maquinas.value.toMutableStateList()

            if(maquina != null) {
                lista.add(maquina!!)
            }

            repositorio.maquinas.value = lista
        }

        //return pokemon
    }
}
