package mx.uacj.pokemon_api.repositorio_api

import mx.uacj.pokemon_api.modelos.Locacion

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import mx.uacj.pokemon_api.modelos.Maquina
import mx.uacj.pokemon_api.modelos.Pokemon
import java.util.Collections.emptyList


class AlmacenDatosMaquinas(
    override val maquinas: MutableState<List<Maquina>> = mutableStateOf(emptyList<Maquina>())
) :RepositorioMaquinas{
}


interface RepositorioMaquinas{
    val maquinas: MutableState<List<Maquina>>
}