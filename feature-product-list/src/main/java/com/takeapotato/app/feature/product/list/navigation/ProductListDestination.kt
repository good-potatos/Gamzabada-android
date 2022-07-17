package com.takeapotato.app.feature.product.list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.takeapotato.app.feature.product.list.ProductListRoute
import com.takeapotato.core.ui.navigation.GamzaNavigationDestination

object ProductListDestination: GamzaNavigationDestination {
    override val route: String = "product_list_route"
    override val destination: String = "product_list_destination"

}

fun NavGraphBuilder.productListGraph() {
    composable(route = ProductListDestination.route) {
        ProductListRoute()
    }
}
