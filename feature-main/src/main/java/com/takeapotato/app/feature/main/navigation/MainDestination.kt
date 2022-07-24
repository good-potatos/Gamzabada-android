package com.takeapotato.app.feature.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.takeapotato.app.feature.main.MainRoute
import com.takeapotato.core.ui.navigation.GamzaNavigationDestination

object MainDestination: GamzaNavigationDestination {
    override val route: String = "main_route"
    override val destination: String = "main_destination"

}

fun NavGraphBuilder.mainGraph() {
    composable(route = MainDestination.route) {
        MainRoute()
    }
}
