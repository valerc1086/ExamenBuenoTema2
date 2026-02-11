package com.example.valeriarubiocarrasco.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.google.firebase.auth.FirebaseAuth

@Composable
fun GestionNavegacion(
    auth: FirebaseAuth
){
    val pilaNavegacion: NavBackStack<NavKey> = //(Routes.Login)

}