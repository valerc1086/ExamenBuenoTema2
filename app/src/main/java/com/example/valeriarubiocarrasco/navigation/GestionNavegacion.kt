package com.example.valeriarubiocarrasco.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.valeriarubiocarrasco.view.HomeScreen
import com.example.valeriarubiocarrasco.view.LoginScreen
import com.example.valeriarubiocarrasco.view.NuevoJugadorScreen
import com.example.valeriarubiocarrasco.viewmodel.HomeViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun GestionNavegacion(
    auth: FirebaseAuth
){
    val pilaNavegacion: NavBackStack<NavKey> = rememberNavBackStack(Routes.LoginScreen)
    val homeViewModel: HomeViewModel = viewModel()

    NavDisplay(
        backStack = pilaNavegacion,
        onBack = {pilaNavegacion.removeLastOrNull()},
        entryProvider ={ key ->
            when(key){
                is Routes.LoginScreen -> NavEntry(key){
                    LoginScreen(
                        auth,
                        onLoginClick = {
                            pilaNavegacion.add(Routes.HomeScreen)
                        }
                    )

                }
                is Routes.HomeScreen -> NavEntry(key){
                    HomeScreen(
                        auth = auth,
                        homeViewModel,
                        onClickAgregarJ = {
                            pilaNavegacion.add(Routes.NuevoJugadorScreen)
                        }
                    )
                }

                is Routes.NuevoJugadorScreen -> NavEntry(key){
                    NuevoJugadorScreen(
                        homeViewModel,
                        onCancelar = {
                            pilaNavegacion.removeLastOrNull()
                            pilaNavegacion.add(Routes.HomeScreen)
                        }
                    )
                }

                else -> NavEntry(key){
                    Text("Pantalla no encontrada")
                }
            }

        }
    )


}