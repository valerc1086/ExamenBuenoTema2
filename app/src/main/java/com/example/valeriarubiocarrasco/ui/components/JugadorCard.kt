package com.example.valeriarubiocarrasco.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import com.example.valeriarubiocarrasco.model.Jugador

@Composable
fun JugadorCard(
    jugador:Jugador,
    onDeleteClick: () -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()

    ){
        Column(){
            AsyncImage(
                model = jugador.urlImagen,
                contentDescription = "Imagen del jugador",
            )

            Row(){
               Icon(
                   contentDescription = "${jugador.numero}",
                   painter = painterResource(jugador.numero)
               )
                Column(){
                    Text("${jugador.nombre}")
                    Text("${jugador.nacionalidad}")
                    Text("${jugador.posicion}")
                }
                IconButton(onDeleteClick) {
                    Icon(Icons.Default.Delete,"Eliminar")
                }

            }
        }

    }

}