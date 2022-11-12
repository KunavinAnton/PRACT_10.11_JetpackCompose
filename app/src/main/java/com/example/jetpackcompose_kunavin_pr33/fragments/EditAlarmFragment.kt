package com.example.jetpackcompose_kunavin_pr33.fragments

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose_kunavin_pr33.*
import com.example.jetpackcompose_kunavin_pr33.R
import com.example.jetpackcompose_kunavin_pr33.ui.theme.*
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@Composable
fun EditAlarmFragment(navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Green
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            GeneralActivityHead(navController ,"Изменить будильник", R.drawable.back_button, 28, 58, 18, NavigationItems.Alarm)
            Column(modifier = Modifier.size(428.dp, 598.dp), horizontalAlignment = Alignment.CenterHorizontally){
                Row(modifier = Modifier.size(318.dp, 58.dp).padding(top = 8.dp)) {
                    AddTextFieldIcon(hint = "16:30", sizeWidth = 158.dp, sizeHeight = 48.dp, icon = R.drawable.alarm_icon)
                    AddTextFieldIcon(hint = "14.01.2021", sizeWidth = 158.dp, sizeHeight = 48.dp, icon = R.drawable.calendar_icon)
                }
                Column(modifier = Modifier.size(318.dp, 568.dp).padding(top = 8.dp)) {
                    AddCheckBoxes(list = list)
                    AddButton(navController, "Удалить будильник",  Red,  22, 18, NavigationItems.Alarm)
                    AddButton(navController, "Сохранить будильник", LightGreen, 22, 8, NavigationItems.Alarm)
                }
            }
        }
    }
}
