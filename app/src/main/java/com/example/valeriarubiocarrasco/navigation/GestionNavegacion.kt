package com.example.valeriarubiocarrasco.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.google.firebase.auth.FirebaseAuth

@Composable
fun GestionNavegacion(
    auth: FirebaseAuth
){
    val pilaNavegacion: NavBackStack<NavKey> = rememberNavBackStack()
    //val homeViewModel: HomeViewModel = viewModel()

    NavDisplay(
        backStack = pilaNavegacion,
        onBack = {pilaNavegacion.removeLastOrNull()},
        entryProvider ={ key ->
            when(key){
                is Routes.Login -> NavEntry(key) {

                }
                }
            }
        }
    )


}