package com.example.jetpackcompose_kunavin_pr33.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose_kunavin_pr33.*
import com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu.ListFragment
import com.example.jetpackcompose_kunavin_pr33.ui.theme.Green
import com.example.jetpackcompose_kunavin_pr33.ui.theme.JetpackCompose_Kunavin_PR33Theme
import com.example.jetpackcompose_kunavin_pr33.ui.theme.LightGreen

@Composable
fun ProfileFragment(navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Green
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            GeneralActivityHead(navController ,"Профиль пользователя", R.drawable.back_button, 28, 58, 8, NavigationItems.List)
            AddProfileIcon()
            Column(modifier = Modifier.size(428.dp, 198.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                AddButton(navController, "Войти",  LightGreen,  24, 18, NavigationItems.UserLogin)
                AddButton(navController, "Регистрация", LightGreen, 24, 8, NavigationItems.UserRegistration)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainActivity() {
    JetpackCompose_Kunavin_PR33Theme {

    }
}