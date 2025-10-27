package mx.uacj.pokemon_api.ui.molecula

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import mx.uacj.pokemon_api.modelos.Pokemon

@Composable
fun PokemonLista(pokemon: Pokemon, modificador: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(
            color = Color(0xFFCECECE.toLong()), // fondo para cada comentario
        ))
    {
        Text("Nombre: ${pokemon.name}")
        Text("Altura: ${pokemon.height}")
        Text("Peso: ${pokemon.weight}")
    }
}
