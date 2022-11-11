package com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcompose_kunavin_pr33.*
import com.example.jetpackcompose_kunavin_pr33.ui.theme.Green
import com.example.jetpackcompose_kunavin_pr33.ui.theme.LightGreen


@Composable
fun ListFragment(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(Modifier.background(Green), verticalArrangement = Arrangement.SpaceBetween) {
            GeneralActivityHead("Список дел", R.drawable.avatar, 28, 68, 28)
            Conversation(messages)
            AddButton(name = "Добавить задачу", color = LightGreen, textSize = 22, paddingTop = 68)
        }
    }
}