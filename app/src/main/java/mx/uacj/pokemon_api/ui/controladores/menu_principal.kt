package mx.uacj.pokemon_api.ui.controladores

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import mx.uacj.pokemon_api.ui.pantallas.PantallaLocacion
import mx.uacj.pokemon_api.ui.pantallas.PantallaMaquinas
import mx.uacj.pokemon_api.ui.pantallas.PantallaPrincipal

data class OpcionesMenu(
    val titulo: String,
    val icono: String,
    val ruta: String
)

@Composable
fun OpcionesMenuInferior(
        opciones: List<OpcionesMenu>,
        ruta_acutal: String,
        al_pushopicar: () -> Unit
){
    BottomAppBar {
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            for (opcion in opciones) {
                Text("${opcion.titulo}", modifier = Modifier.clickable {
                    Log.v("NavegacionInferior", "${opcion.titulo}")
                })
            }
        }
    }
}
@Composable
fun MenuPrincipal(){
    val lista_opciones_menu by remember {  mutableStateOf(
        mutableStateListOf(
            OpcionesMenu("Pokemones", "icono", "PantallaPokemones"),
            OpcionesMenu("Ubicaciones", "icono", "PantallaPokemones"),
            OpcionesMenu("Maquinas", "icono", "PantallaPokemones"),
            )
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            OpcionesMenuInferior(
                lista_opciones_menu,
                ruta_acutal = "TODO()",
                al_pushopicar = { },
            )
        }
    ) { innerPadding ->
        PantallaPrincipal(modificador = Modifier.padding(innerPadding))
    }
}
