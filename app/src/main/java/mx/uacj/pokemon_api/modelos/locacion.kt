package mx.uacj.pokemon_api.modelos

data class Locacion(
    val id: Int,
    val name: String,
    val region: Region,
    val areas: List<Area>?
)

