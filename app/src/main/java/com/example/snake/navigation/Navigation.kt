package com.example.snake.navigation


import androidx.compose.runtime.Composable
import androidx.compose.material3.*


@Composable
fun MainScreen() {
    //Pantailen egitura eta nabigazioa sortu

    //val gameViewModel = SnakeGameViewModel()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { },
        actions = {

            IconButton(onClick = {
            //Intent gehitu
            }) {
            //Ikonoa gehitu
            }
            //Gainerako IconButton-ak gehitu
        }
    )
}

