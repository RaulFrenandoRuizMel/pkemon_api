package mx.uacj.pokemon_api.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.uacj.pokemon_api.modelos.Pokemon
import mx.uacj.pokemon_api.ui.molecula.PokemonLista
import mx.uacj.pokemon_api.viewmodels.PokemonesViewModel


@Composable
fun PantallaPrincipal(modificador: Modifier = Modifier,
                      controlador_pokemones: PokemonesViewModel = hiltViewModel()) {
    val controlador_navegacion = rememberNavController()

    var pokemon_seleccionado by remember { mutableStateOf<Pokemon?>(null) }

    NavHost(navController = controlador_navegacion, startDestination = "lista_pokemones"){
        composable("lista_pokemones") {
            Column(modifier = modificador) {
                Column {
                    Text("Atrapa a los ${controlador_pokemones.pokemones.value.size} pokemones")
                }

                Column(modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .background(
                            color = Color(0xFFD1B3C4.toLong()), // fondo para cada comentario
                        )
                    ){
                    for (pokemon in controlador_pokemones.pokemones.value) {
                        PokemonLista(pokemon = pokemon, modificador = Modifier.clickable {
                            pokemon_seleccionado = pokemon
                            controlador_navegacion.navigate("pantalla_pokemones")
                        })
                        Spacer(modifier = Modifier.height(24.dp)) // 👈 espacio vertical entre cada item
                    }
                }
            }
        }

        composable("pantalla_pokemones") {
            PantallaPokemon(modificador = modificador, pokemon = pokemon_seleccionado!!)
        }
    }


}

@Composable
@Preview(showBackground = true)
fun PreviewPantallaPrincipal(){
    PantallaPrincipal()
}
