package com.tooke.app.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tooke.app.ui.screens.AboutScreen
import com.tooke.app.ui.screens.DetailScreen
import com.tooke.app.ui.screens.HomeScreen
import com.tooke.app.viewmodel.FoodSpotViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{spotId}") {
        fun createRoute(spotId: Int) = "detail/$spotId"
    }
    object About : Screen("about")
}

@Composable
fun TookeApp() {
    val navController = rememberNavController()
    val viewModel: FoodSpotViewModel = viewModel()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavRoutes = listOf(Screen.Home.route, Screen.About.route)

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomNavRoutes) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = NavigationBarDefaults.Elevation
                ) {
                    NavigationBarItem(
                        selected = currentRoute == Screen.Home.route,
                        onClick = {
                            if (currentRoute != Screen.Home.route) {
                                navController.navigate(Screen.Home.route) {
                                    popUpTo(Screen.Home.route) { inclusive = true }
                                }
                            }
                        },
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                        label = { Text("Home") },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                    NavigationBarItem(
                        selected = currentRoute == Screen.About.route,
                        onClick = {
                            if (currentRoute != Screen.About.route) {
                                navController.navigate(Screen.About.route) {
                                    popUpTo(Screen.Home.route)
                                }
                            }
                        },
                        icon = { Icon(Icons.Default.Info, contentDescription = "About") },
                        label = { Text("About") },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    viewModel = viewModel,
                    onSpotClicked = { spotId ->
                        navController.navigate(Screen.Detail.createRoute(spotId))
                    }
                )
            }

            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("spotId") { type = NavType.IntType })
            ) { backStackEntry ->
                val spotId = backStackEntry.arguments?.getInt("spotId") ?: return@composable
                val spot = viewModel.getSpotById(spotId) ?: return@composable
                DetailScreen(
                    spot = spot,
                    onBackClicked = { navController.popBackStack() }
                )
            }

            composable(Screen.About.route) {
                AboutScreen()
            }
        }
    }
}
