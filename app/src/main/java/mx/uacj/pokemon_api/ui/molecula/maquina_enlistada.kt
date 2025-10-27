package mx.uacj.pokemon_api.ui.molecula

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import mx.uacj.pokemon_api.modelos.Locacion
import mx.uacj.pokemon_api.modelos.Maquina
import mx.uacj.pokemon_api.modelos.Pokemon

@Composable
fun MaquinaLista(maquina: Maquina, modificador: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(
            color = Color(0xFFCECECE.toLong()), // fondo para cada comentario
        )) {
        Text("Id: ${maquina.id}")
        Text("Nombre de la maquina: ${maquina.item.name}")
        Text("Movimiento: ${maquina.move.name}")
        Text("Version Group: ${maquina.version_group.name}")
    }
}