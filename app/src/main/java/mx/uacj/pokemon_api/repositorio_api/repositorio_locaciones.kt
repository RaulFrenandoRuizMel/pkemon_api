package mx.uacj.pokemon_api.repositorio_api

import mx.uacj.pokemon_api.modelos.Locacion

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import mx.uacj.pokemon_api.modelos.Pokemon
import java.util.Collections.emptyList


class AlmacenDatosLocacion(
    override val locaciones: MutableState<List<Locacion>> = mutableStateOf(emptyList<Locacion>())
) :RepositorioLocaciones{
}


interface RepositorioLocaciones{
    val locaciones: MutableState<List<Locacion>>
}