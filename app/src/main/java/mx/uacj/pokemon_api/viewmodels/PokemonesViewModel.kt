package mx.uacj.pokemon_api.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mx.uacj.pokemon_api.modelos.Pokemon
import mx.uacj.pokemon_api.repositorio_api.RepositorioPokemones
import mx.uacj.pokemon_api.repositorio_api.api_conexion.InterfazPokemonAPI
import javax.inject.Inject
import androidx.compose.runtime.State

@HiltViewModel
class PokemonesViewModel @Inject constructor(
    private val repositorio: RepositorioPokemones,
    private val conexion_server: InterfazPokemonAPI
): ViewModel(){
    private var estado = mutableStateOf("cargando")

    public val pokemones: State<List<Pokemon>> = repositorio.pokemones

    init {
        for(indice_pokemon in 1..50) {
            descargar_pokemon(indice_pokemon)
        }
    }

    fun descargar_pokemon(id: Int){
       var pokemon: Pokemon? = null

        viewModelScope.launch {
            pokemon = conexion_server.descargar_pokemon(id)
            //pokemon_cache = mutableStateOf(pokemon_descargado)
            val lista = repositorio.pokemones.value.toMutableStateList()

            if(pokemon != null) {
                lista.add(pokemon!!)
            }

            repositorio.pokemones.value = lista
        }

        //return pokemon
    }
}
