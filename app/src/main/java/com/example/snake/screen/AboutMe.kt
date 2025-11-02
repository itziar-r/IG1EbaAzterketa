package com.example.snake.screen

import com.example.snake.R
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


data class MiniGame(val title: String, val description: String, val imageResId: Int)

@Composable
fun AboutScreen() {
    val miniGames = listOf(
        MiniGame("Memoria jolasa", "Kartak gogoratu eta bikoteak aurkitu.",R.drawable.juegomemoria),
        MiniGame("3 marran", "Lortu 3 marran aurkariak baino lehen",R.drawable.juegoenraya),
        MiniGame("Zenbakia asmatu", "Asmatu zenbaki sekretua",R.drawable.juegoadivinanumero),
        MiniGame("Azkar sakatu", "Sakatu botoia ahal adina aldiz 10 segundotan.",R.drawable.juegopulsarapido),
    )


}

@Composable
fun MiniGameCard(miniGame: MiniGame) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        //Mini jolasen txartelak gehitu
    }
}


