package com.example.valeriarubiocarrasco.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey{
    @Serializable
    data object HomeScreen: Routes()

    @Serializable
    data object LoginScreen: Routes()

    @Serializable
    data object NuevoJugadorScreen: Routes()
}