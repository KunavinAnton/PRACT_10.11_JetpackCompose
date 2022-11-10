package com.example.jetpackcompose_kunavin_pr33

sealed class NavigationItems(var route: String, var icon: Int, var title: String){
    object List : NavigationItems("list", R.drawable.list_icon, "List")
    object Alarm : NavigationItems("alarm", R.drawable.alarm_icon, "Alarm")
    object Calendar : NavigationItems("calendar", R.drawable.calendar_icon, "Calendar")
    object Settings : NavigationItems("settings", R.drawable.settings_icon, "Settings")
}
