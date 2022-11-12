package com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose_kunavin_pr33.*
import com.example.jetpackcompose_kunavin_pr33.R
import com.example.jetpackcompose_kunavin_pr33.ui.theme.Green
import com.example.jetpackcompose_kunavin_pr33.ui.theme.LightGreen

@Composable
fun AlarmFragment(navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Green
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(bottom = 18.dp)) {
            GeneralActivityHead(navController,"Будильник", R.drawable.avatar, 28, 68, 28)
            Column(modifier = Modifier.size(428.dp, 328.dp)){
                AddSwitch(navController, time = "07:30", NavigationItems.EditAlarm)
                AddSwitch(navController, time = "08:00", NavigationItems.EditAlarm)
            }
            AddButton(navController, "Добавить будильник", LightGreen,  22, 48, NavigationItems.CreateAlarm)
        }
    }
}