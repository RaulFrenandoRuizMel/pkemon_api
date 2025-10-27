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
import mx.uacj.pokemon_api.modelos.Locacion
import mx.uacj.pokemon_api.ui.molecula.LocacionLista
import mx.uacj.pokemon_api.viewmodels.LocacionesViewModel


@Composable
fun PantallaLocacion(modificador: Modifier = Modifier,
                      controlador_locaciones: LocacionesViewModel = hiltViewModel()) {
    val controlador_navegacion = rememberNavController()

    var locacion_seleccionada by remember { mutableStateOf<Locacion?>(null) }

    NavHost(navController = controlador_navegacion, startDestination = "lista_locacion"){
        composable("lista_locacion") {
            Column(modifier = modificador) {
                Column {
                    Text("Explora las ${controlador_locaciones.locaciones.value.size} locaciones")
                }

                Column(modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .background(
                        color = Color(0xFFD1B3C4.toLong()), // fondo para cada comentario
                    ))
                 {
                    for (locacion in controlador_locaciones.locaciones.value) {
                        LocacionLista(locacion = locacion, modificador = Modifier.clickable {
                            locacion_seleccionada = locacion
                            controlador_navegacion.navigate("pantalla_locaciones")
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
fun PreviewPantallaLocacion(){
    PantallaLocacion()
}
