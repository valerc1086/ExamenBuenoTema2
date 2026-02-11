package com.example.valeriarubiocarrasco.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun NuevoJugadorScreen(
    onAgregarJugador: () -> Unit,
    onCancelar: () -> Unit
){
    Column(

    ){
        var nombre by remember { mutableStateOf("") }
        var numero by remember{mutableStateOf("")}
        var posicion by remember{mutableStateOf("")}
        var nacionalidad by remember{mutableStateOf("")}
        var urlimagen by remember{mutableStateOf("")}

        Text("Nuevo jugador")

        Spacer(modifier = Modifier.width(15.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it},
            label ={ Text("Nombre")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.width(10.dp))

        OutlinedTextField(
            value = numero,
            onValueChange = {numero= it},
            label ={ Text("Número")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.width(10.dp))

        OutlinedTextField(
            value = posicion,
            onValueChange = {posicion = it},
            label = {Text("Posición")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.width(10.dp))

        OutlinedTextField(
            value = nacionalidad,
            onValueChange = {nacionalidad = it},
            label ={ Text("Nacionalidad")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.width(10.dp))

        OutlinedTextField(
            value = urlimagen,
            onValueChange = {urlimagen= it},
            label ={ Text("URL imagen")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()

        )

        Spacer(modifier = Modifier.width(15.dp))

        Row(){
            Button(
                onClick = onAgregarJugador
            ) {
                Text("Agregar Jugador")
            }
            Button(
                onClick = onCancelar
            ) {
                Text("Cancelar")
            }
        }
    }
}