package mx.uacj.pokemon_api.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.uacj.pokemon_api.modelos.Locacion
import mx.uacj.pokemon_api.modelos.Maquina
import mx.uacj.pokemon_api.ui.molecula.LocacionLista
import mx.uacj.pokemon_api.ui.molecula.MaquinaLista
import mx.uacj.pokemon_api.viewmodels.LocacionesViewModel
import mx.uacj.pokemon_api.viewmodels.MaquinasViewModel
import androidx.compose.ui.graphics.Color



@Composable
fun PantallaMaquinas(modificador: Modifier = Modifier,
                     controlador_maquinas: MaquinasViewModel = hiltViewModel()) {
    val controlador_navegacion = rememberNavController()

    var maquina_seleccionada by remember { mutableStateOf<Maquina?>(null) }

    NavHost(navController = controlador_navegacion, startDestination = "lista_maquina"){
        composable("lista_maquina") {
            Column(modifier = modificador) {
                Column {
                    Text("Encuentra las ${controlador_maquinas.maquinas.value.size} maquinas")
                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .background(
                        color = Color(0xFFD1B3C4.toLong()), // fondo para cada comentario
                    )
                ) {
                    for (maquina in controlador_maquinas.maquinas.value) {
                        MaquinaLista(maquina = maquina, modificador = Modifier.clickable {
                            maquina_seleccionada = maquina
                            controlador_navegacion.navigate("pantalla_maquinas")
                        })
                        Spacer(modifier = Modifier.height(24.dp)) // 👈 espacio vertical entre cada item
                    }
                }
            }
        }
    }


}

@Composable
@Preview(showBackground = true)
fun PreviewPantallaMaquina(){
    PantallaMaquinas()
}
