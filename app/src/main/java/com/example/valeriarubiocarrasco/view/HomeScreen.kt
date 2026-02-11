package com.example.valeriarubiocarrasco.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.valeriarubiocarrasco.ui.components.JugadorCard
import com.example.valeriarubiocarrasco.viewmodel.HomeViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(
    auth: FirebaseAuth,
    viewModel: HomeViewModel = viewModel(),
    onClickAgregarJ: () -> Unit
){
    Scaffold(){ paddingValues ->
        val jugadores by viewModel.jugador.collectAsState()

        Text("Plantilla temporada 25/26")

        LazyColumn(
            contentPadding = PaddingValues(vertical = 5.dp)
        ) {
            items(
                jugadores,
                key = {it.id}
            ){ item ->
                JugadorCard(
                    jugador = item,
                    onDeleteClick = {viewModel.deleteJugador(item.id)}
                )
            }
        }

        Button(
            onClick = { onClickAgregarJ()}
        ){
            Text("Agregar Jugador")
        }
    }

}