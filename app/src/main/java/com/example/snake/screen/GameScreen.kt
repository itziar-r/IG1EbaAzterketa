package com.example.snake.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.snake.viewmodel.SnakeGameViewModel
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun SnakeGameScreen(viewModel: SnakeGameViewModel) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    val cellSize = 20.dp
    fun cellToDp(pos: Int): Dp = (pos * cellSize.value).dp

    var snake by remember { mutableStateOf(listOf(Pair(5, 5), Pair(5, 6), Pair(5, 7))) }
    var direction by remember { mutableStateOf(Pair(0, -1)) } // hacia arriba
    var food by remember { mutableStateOf(Pair(8, 8)) }

    // Tamainua gelaxkatan
    val maxX = (screenWidth / cellSize).toInt() - 1
    val maxY = (screenHeight / cellSize).toInt() - 1

    // Erabilzaileren ukitua detektatu
    val touchModifier = Modifier.pointerInput(Unit) {
        detectTapGestures { offset ->
            val head = snake.first()
            val headX = cellToDp(head.first).value
            val headY = cellToDp(head.second).value

            // Norabidea aldatu non ukitu den arabera
            direction = when {
                offset.x < headX.dp.toPx() && direction.first == 0 -> Pair(-1, 0) // izquierda
                offset.x > headX.dp.toPx() && direction.first == 0 -> Pair(1, 0)  // derecha
                offset.y < headY.dp.toPx() && direction.second == 0 -> Pair(0, -1) // arriba
                offset.y > headY.dp.toPx() && direction.second == 0 -> Pair(0, 1)  // abajo
                else -> direction
            }
        }
    }

    // Mugimendu automatikoa
    LaunchedEffect(Unit) {
        while (true) {
            delay(200L)

            val head = snake.first()
            var newHead = Pair(head.first + direction.first, head.second + direction.second)

            // Pantailaren mugetatik irtetea ekidin
            val boundedX = newHead.first.coerceIn(0, maxX)
            val boundedY = newHead.second.coerceIn(0, maxY)
            newHead = Pair(boundedX, boundedY)

            // Sugea eguneratu
            snake = listOf(newHead) + snake.dropLast(1)

            // Janaria jan
            if (newHead == food) {
                snake = snake + listOf(snake.last())
                food = Pair(
                    Random.nextInt(0, maxX),
                    Random.nextInt(0, maxY)
                )
            }
        }
    }

    // Jolasa marraztea
    // atzealdeko kolorea, resource irudia edo galeriatik inportatutako irudia gehitu (kondizionalak erabili)
    // Irudiak atzealdera egokitzeko, erabili:
    //    modifier = Modifier.fillMaxSize(),
    //    contentScale = ContentScale.FillBounds

    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(touchModifier) // ukituen detektatzailea gehitzen da
            .background(Color.White)
    ) {
        //Atzealdeko irudiak gehitu (kondizionalak erabili)

        //Janaria
        Box(
            modifier = Modifier
                .offset(x = cellToDp(food.first), y = cellToDp(food.second))
                .size(cellSize)
                .background(Color.Red)
        ){
            // Janaria gehitu (kolore edo resource irudia). Kondizionalak erabili
        }


        // Sugea
        snake.forEach { (x, y) ->
            Box(
                modifier = Modifier
                    .offset(x = cellToDp(x), y = cellToDp(y))
                    .size(cellSize)
                    .background(Color.Blue)
            )
        }
    }
}
