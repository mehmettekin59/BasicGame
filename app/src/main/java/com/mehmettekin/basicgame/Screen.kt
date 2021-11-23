package com.mehmettekin.basicgame

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object Play: Screen(route = "play_screen")
    object Result: Screen(route = "result_screen/{result}"){
        fun passResult(result: Boolean):String{
            return "result_screen/$result"
        }
    }
}
