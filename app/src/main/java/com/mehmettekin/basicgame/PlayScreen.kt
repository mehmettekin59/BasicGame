package com.mehmettekin.basicgame

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlin.random.Random

@Composable
fun PlayScreen(navController: NavHostController) {
    var number by remember { mutableStateOf("") }
    var livesLeft = remember { mutableStateOf(5) }
    var direction by remember { mutableStateOf("") }
    val randomNumber = remember{ mutableStateOf(0)}


LaunchedEffect(key1 = true ){
    randomNumber.value = Random.nextInt(1,100)
    Log.e("number",randomNumber.value.toString())
}

   Column(modifier = Modifier
       .fillMaxSize()
       .background(MaterialTheme.colors.secondary),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.SpaceEvenly

   ) {
       Text(text = "Live Left : ${livesLeft.value}" , fontSize = 32.sp, color = Color.Blue)
       Text(text = "Help : $direction", fontSize = 30.sp, color = Color.Blue)
       OutlinedTextField(
           value = number ,
           onValueChange = {number = it},
           label = { Text(text = "Enter your number")},
           placeholder = { Text(text = "Guess")}
       )
       Button(onClick = {
            livesLeft.value = livesLeft.value - 1
           val guessNumber = number.toInt()

           if (guessNumber == randomNumber.value){
               navController.navigate(route = Screen.Result.passResult(true)){
                   popUpTo(Screen.Play.route){
                       inclusive = true
                   }
               }
               return@Button
           }
           if (guessNumber > randomNumber.value){
                direction = "Decrease"
           }
           if (guessNumber < randomNumber.value){
               direction = "Increase"
           }

           if (livesLeft.value == 0){
               navController.navigate(route = Screen.Result.passResult(false)){
                   popUpTo(Screen.Play.route){
                       inclusive = true
                   }
               }
           }

           number = ""

        }) {
           Text(text = "Guess")
       }
   }

}