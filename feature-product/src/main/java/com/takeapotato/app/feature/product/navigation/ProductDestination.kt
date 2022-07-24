package com.takeapotato.app.feature.product.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.takeapotato.app.feature.product.ProductRoute
import com.takeapotato.core.ui.navigation.GamzaNavigationDestination

object ProductDestination : GamzaNavigationDestination {
    override val route: String = "product_route"
    override val destination: String = "product_destination"
    const val productIdArg = "productIdArg"
}

fun NavGraphBuilder.productGraph(
    onBackClick: () -> Unit
) {
    composable(
        route = "${ProductDestination.route}/{${ProductDestination.productIdArg}}",
        arguments = listOf(
            navArgument(ProductDestination.productIdArg) {
                type = NavType.StringType
            }
        )) {
        ProductRoute(onBackClick = onBackClick)
    }

}
