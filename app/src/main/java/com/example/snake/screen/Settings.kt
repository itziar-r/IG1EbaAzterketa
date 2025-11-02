package com.example.snake.screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.snake.viewmodel.SnakeGameViewModel

@Composable
fun SettingsScreen(gameViewModel: SnakeGameViewModel = viewModel()) {
    val snakeColors = listOf(Color.Red, Color.Blue, Color.Yellow)
    val appleColors = listOf(Color.Green, Color.DarkGray, Color.Cyan)
    val backgroundColors = listOf(Color.Cyan, Color.LightGray, Color.White)

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { selectedImageUri: Uri? ->

        if (selectedImageUri != null) {
            //Erabiltzaileak irudi bat aukeratu du, gehitu selectedImageUri viewModel-era
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Janaria", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            appleColors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(color)
                        .clickable {//Gehitu viewmodel-era aukeratutako sagar kolorea
                             }

                )
            }
            //Gehitu box batean sagarraren irudia resources-etik
            }
        }

        //Janariaren berdina egin sugearen kolorearekin
        //Janari eta sugearen berdina egin atzealdearen kolorearekin
            //Gehitu atzealdeko koloreak
            //Belarraren irudia resources-etik gehitu eta aukeratzean gorde viewmodel-ean
            //Gehitu botoi bat galeriako irudi bat aukeratzeko eta aukeratzean gorde viewmodel-ean

           Button(
                onClick = { imagePickerLauncher.launch("image/*") },
                modifier = Modifier.height(40.dp)
            ) {

            }
        }



