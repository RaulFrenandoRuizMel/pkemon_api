package mx.uacj.pokemon_api.ui.molecula

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import mx.uacj.pokemon_api.modelos.Locacion
import mx.uacj.pokemon_api.modelos.Pokemon

@Composable
fun LocacionLista(locacion: Locacion, modificador: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(
            color = Color(0xFFCECECE.toLong()), // fondo para cada comentario
        ))    {
        Text("Id: ${locacion.id}")
        Text("Nombre de Locacion: ${locacion.name}")
        Text("Region: ${locacion.region.name}")
    }
}
