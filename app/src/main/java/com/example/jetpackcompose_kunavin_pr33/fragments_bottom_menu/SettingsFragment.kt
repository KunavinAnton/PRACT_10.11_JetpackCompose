package com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose_kunavin_pr33.*
import com.example.jetpackcompose_kunavin_pr33.R
import com.example.jetpackcompose_kunavin_pr33.ui.theme.Green
import com.example.jetpackcompose_kunavin_pr33.ui.theme.LightGreen

@Composable
fun SettingsFragment(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(Modifier.background(Green), verticalArrangement = Arrangement.SpaceBetween) {
            GeneralActivityHead("Настройки", R.drawable.avatar, 28, 68, 28)
            Column(modifier = Modifier.size(428.dp, 578.dp)) {
                AddSettingsElement(name = "Профиль пользователя")
                AddSettingsElement(name = "Дата и время")
                AddSettingsElement(name = "Настройка звука")
                AddSettingsElement(name = "Проверить обновления")

            }
        }
    }
}