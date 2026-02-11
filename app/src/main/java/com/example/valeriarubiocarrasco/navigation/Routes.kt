package com.example.valeriarubiocarrasco.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    data object Home: Routes()

    @Serializable
    data object Login: Routes()

    @Serializable
    data object NuevoJugador: Routes()
}