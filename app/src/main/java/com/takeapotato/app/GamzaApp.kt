package com.takeapotato.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.takeapotato.app.feature.product.list.ProductListRoute
import com.takeapotato.app.feature.product.list.ProductListScreen
import com.takeapotato.app.feature.product.list.navigation.ProductListDestination
import com.takeapotato.app.feature.product.list.navigation.productListGraph
import com.takeapotato.app.feature.search.navigation.searchGraph
import com.takeapotato.app.navigation.GamzaTopLevelNavigation
import com.takeapotato.app.navigation.TOP_LEVEL_DESTINATIONS
import com.takeapotato.core.ui.component.GamzaTopBar
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
            BottomNavigation {
                TOP_LEVEL_DESTINATIONS.forEach { destination ->
                    val selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true
                    BottomNavigationItem(selected = selected,
                        onClick = { gamzaTopLevelNavigation.navigationTo(destination) },
                        icon = { })
                }
            }
        }) { innerPadding ->
            NavHost(navController = navController,
                startDestination = ProductListDestination.route,
                modifier = Modifier.padding(innerPadding)) {
                productListGraph()
                searchGraph()
            }
        }
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Hello it's main text")
        Text("Welcome to Composable world.")
    }
}