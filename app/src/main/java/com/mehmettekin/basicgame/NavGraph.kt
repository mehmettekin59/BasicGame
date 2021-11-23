package com.mehmettekin.basicgame

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
            ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Play.route
        ){
            PlayScreen(navController = navController)
        }

        composable(
            route = Screen.Result.route,
            arguments = listOf(navArgument("result"){
                type = NavType.BoolType
            })
        ){
            Log.d("Args",it.arguments?.getBoolean("result").toString())
            val result = it.arguments?.getBoolean("result")!!
            ResultScreen(navController = navController,result.toString())

        }
    }
}