package com.mehmettekin.basicgame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ResultScreen(navController: NavHostController, result: String) {
    Column(modifier = Modifier.fillMaxSize().background(color = Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        if (result == "true"){
            Text(text = "Congratulations You Win", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
            Image(painter = painterResource(id = R.drawable.happy_face), contentDescription ="happy face")
        }else{
            Text(text = "Sorry You lost", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
            Image(painter = painterResource(id = R.drawable.dissatisfied), contentDescription ="happy face")
        }

    }
}