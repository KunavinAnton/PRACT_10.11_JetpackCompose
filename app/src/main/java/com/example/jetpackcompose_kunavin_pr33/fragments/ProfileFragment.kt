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
import com.example.jetpackcompose_kunavin_pr33.*
import com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu.ListFragment
import com.example.jetpackcompose_kunavin_pr33.ui.theme.Green
import com.example.jetpackcompose_kunavin_pr33.ui.theme.JetpackCompose_Kunavin_PR33Theme
import com.example.jetpackcompose_kunavin_pr33.ui.theme.LightGreen

@Composable
fun ProfileFragment(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(Modifier.background(Green), verticalArrangement = Arrangement.SpaceBetween) {
            GeneralActivityHead("Профиль пользователя", R.drawable.back_button, 28, 58, 8)
            AddProfileIcon()
            Column(modifier = Modifier.size(428.dp, 198.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                AddButton(name = "Войти", color = LightGreen, textSize = 24, paddingTop = 18)
                AddButton(name = "Регистрация", color = LightGreen, textSize = 24, paddingTop = 8)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackCompose_Kunavin_PR33Theme {
        AddButton(name = "Войти", color = LightGreen, textSize = 24, paddingTop = 28)
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivity() {
    JetpackCompose_Kunavin_PR33Theme {
        ProfileFragment()
    }
}