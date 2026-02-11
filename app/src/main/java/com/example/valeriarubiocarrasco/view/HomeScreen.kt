package com.example.valeriarubiocarrasco.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.valeriarubiocarrasco.ui.components.JugadorCard
import com.example.valeriarubiocarrasco.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    onClickAgregarJ: () -> Unit
){
    Scaffold() { paddingValues ->
        val jugadores by viewModel.jugador.collectAsState()

        Column(modifier = Modifier
            .fillMaxHeight()
            .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            Text("Plantilla temporada 25/26", fontSize = 25.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(15.dp))
            LazyColumn(
                contentPadding = PaddingValues(vertical = 5.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(
                    jugadores,
                    key = { it.id }
                ) { item ->
                    JugadorCard(
                        jugador = item,
                        onDeleteClick = { viewModel.deleteJugador(item.id) }
                    )
                }
            }

            Button(
                onClick = { onClickAgregarJ() },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF27D21F)
                )
            ) {
                Text("Agregar Jugador")
            }
        }
    }

}