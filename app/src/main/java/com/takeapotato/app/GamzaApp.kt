package com.takeapotato.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.takeapotato.app.feature.main.navigation.MainDestination
import com.takeapotato.app.feature.main.navigation.mainGraph
import com.takeapotato.app.feature.product.list.navigation.ProductListDestination
import com.takeapotato.app.feature.product.list.navigation.productListGraph
import com.takeapotato.app.feature.product.navigation.ProductDestination
import com.takeapotato.app.feature.product.navigation.productGraph
import com.takeapotato.app.navigation.GamzaTopLevelNavigation
import com.takeapotato.app.navigation.TOP_LEVEL_DESTINATIONS
import com.takeapotato.core.ui.theme.GamzaTheme

@Composable
fun GamzaApp() {
    GamzaTheme {
        val navController = rememberNavController()
        val gamzaTopLevelNavigation = remember(navController) {
            GamzaTopLevelNavigation(navController)
        }

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        Scaffold(modifier = Modifier, bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White
            ) {
                TOP_LEVEL_DESTINATIONS.forEach { destination ->
                    val selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true
                    BottomNavigationItem(selected = selected,
                        onClick = { gamzaTopLevelNavigation.navigationTo(destination) },
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = null
                            )
                        })
                }
            }
        }) { innerPadding ->
            NiaNavHost(navController = navController)
        }
    }
}

@Composable
fun NiaNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        mainGraph()
        productListGraph(
            navigateToProduct = { navController.navigate("${ProductDestination.route}/$it") },
            nestedGraphs = {
                productGraph(onBackClick = { navController.popBackStack() })
            }
        )
    }
}