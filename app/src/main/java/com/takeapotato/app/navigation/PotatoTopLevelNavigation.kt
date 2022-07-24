package com.takeapotato.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.takeapotato.app.feature.main.navigation.MainDestination
import com.takeapotato.app.feature.product.list.navigation.ProductListDestination
import com.takeapotato.app.feature.search.navigation.SearchDestination

class GamzaTopLevelNavigation(private val navController: NavHostController) {

    fun navigationTo(destination: TopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true
            restoreState = true
        }
    }
}

data class TopLevelDestination(
    val route: String,
//    val selectedIcon: Painter,
//    val unselectedIcon: Painter,
)

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = MainDestination.route,
//        selectedIcon = Icons.Filled.Upcoming,
//        unselectedIcon = Icons.Outlined.Upcoming,
    ),
    TopLevelDestination(
        route = ProductListDestination.route,
//        selectedIcon = Icons.Filled.Grid3x3,
//        unselectedIcon = Icons.Outlined.Grid3x3,
    )
)

