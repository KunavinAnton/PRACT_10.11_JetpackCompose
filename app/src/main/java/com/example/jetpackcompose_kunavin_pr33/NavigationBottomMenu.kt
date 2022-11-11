package com.example.jetpackcompose_kunavin_pr33

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose_kunavin_pr33.fragments.ProfileFragment
import com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu.AlarmFragment
import com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu.CalendarFragment
import com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu.ListFragment
import com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu.SettingsFragment

@Composable
fun NavigationBottomMenu(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItems.List.route){
        composable(route = NavigationItems.List.route){
            ListFragment()
        }
        composable(route = NavigationItems.Alarm.route){
            AlarmFragment()
        }
        composable(route = NavigationItems.Calendar.route){
            CalendarFragment()
        }
        composable(route = NavigationItems.Settings.route){
            SettingsFragment()
        }
        composable(route = "profile"){
            ProfileFragment()
        }
    }
}
