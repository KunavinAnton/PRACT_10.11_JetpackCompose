package com.example.jetpackcompose_kunavin_pr33.fragments

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose_kunavin_pr33.*
import com.example.jetpackcompose_kunavin_pr33.R
import com.example.jetpackcompose_kunavin_pr33.ui.theme.Green
import com.example.jetpackcompose_kunavin_pr33.ui.theme.LightGreen
import com.example.jetpackcompose_kunavin_pr33.ui.theme.Red

@Composable
fun UserLoginFragment(navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Green
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            GeneralActivityHead(navController ,"Войти", R.drawable.back_button, 28, 58, 18, NavigationItems.Profile)
            Column(modifier = Modifier.size(428.dp, 478.dp), horizontalAlignment = Alignment.CenterHorizontally){
                AddTextField(hint = "Имя пользователя", sizeWidth = 348.dp, sizeHeight = 48.dp)
                Spacer(modifier = Modifier.padding(bottom = 8.dp))
                AddTextField(hint = "Пароль", sizeWidth = 348.dp, sizeHeight = 48.dp, keyboardType = KeyboardType.Password)
                Spacer(modifier = Modifier.padding(bottom = 8.dp))
                AddButton(navController, "Войти", LightGreen, 22, 8, NavigationItems.Profile)
            }
        }
    }
}