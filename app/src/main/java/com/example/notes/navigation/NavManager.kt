package com.example.notes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notes.view.AddTaskView
import com.example.notes.view.EditTaskView
import com.example.notes.view.HomeView

@Composable
fun NavManager(darkTheme: Boolean, onThemeUpdated: () -> Unit) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homeView") {
        composable("homeView") {
            HomeView(navController, darkTheme, onThemeUpdated)
        }

        composable("addTaskView") {
            AddTaskView(navController)
        }

        composable(
            "editTaskView/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
            )
        ) {
            EditTaskView(
                navController,
                it.arguments!!.getInt("id"),
            )
        }
    }
}