package com.takeapotato.app.feature.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.takeapotato.app.feature.search.SearchRoute
import com.takeapotato.core.ui.navigation.GamzaNavigationDestination

object SearchDestination : GamzaNavigationDestination {
    override val route: String = "search_route"
    override val destination: String = "search_destination"

}

fun NavGraphBuilder.searchGraph() {
    composable(route = SearchDestination.route) {
        SearchRoute()
    }
}
