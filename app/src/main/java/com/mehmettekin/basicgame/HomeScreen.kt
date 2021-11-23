package com.mehmettekin.basicgame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.secondary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Number Game",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
            )
        Image(painter = painterResource(id = R.drawable.live_help), contentDescription = "game")
        Button(onClick = { navController.navigate(route = Screen.Play.route) }) {
            Text(
                text = "BEGIN",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.size(width = 250.dp, height = 50.dp),
                textAlign = TextAlign.Center,

            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen(navController = rememberNavController())
}