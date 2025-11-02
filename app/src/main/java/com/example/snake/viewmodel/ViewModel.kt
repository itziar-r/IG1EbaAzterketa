package com.example.snake.viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class SnakeGameViewModel : ViewModel() {

    // Colores
    val snakeColor = mutableStateOf(Color.Green)
    val appleColor = mutableStateOf(Color.Red)

    // Fondo
    val backgroundColor = mutableStateOf(Color.Black)
    val backgroundImageResId = mutableStateOf<Int?>(null)
    val backgroundImageUri = mutableStateOf<Uri?>(null)
    val appleImageResId = mutableStateOf<Int?>(null)

    fun setSnakeColor(color: Color) {
        snakeColor.value = color
    }


    fun setAppleColor(color: Color) {
        appleColor.value = color
    }

    fun setAppleImageRes(resId: Int) {
        appleImageResId.value = resId
        appleColor.value=Color.Transparent

    }

    fun setBackgroundColor(color: Color) {
        backgroundColor.value = color
        backgroundImageResId.value = null
        backgroundImageUri.value = null
    }

    fun setBackgroundImageRes(resId: Int) {
        backgroundImageResId.value = resId
        backgroundImageUri.value = null
    }


    fun setBackgroundImageUri(uri: Uri) {
        backgroundImageUri.value = uri
        backgroundImageResId.value = null
    }
}
