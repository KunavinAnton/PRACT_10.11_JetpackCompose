package com.example.jetpackcompose_kunavin_pr33

sealed class NavigationItems(var route: String, var icon: Int = -1, var title: String = ""){
    object MainScreen : NavigationItems("main_screen")

    object List : NavigationItems("list", R.drawable.list_icon, "List")
    object Alarm : NavigationItems("alarm", R.drawable.alarm_icon, "Alarm")
    object Calendar : NavigationItems("calendar", R.drawable.calendar_icon, "Calendar")
    object Settings : NavigationItems("settings", R.drawable.settings_icon, "Settings")

    object AddTask : NavigationItems("add_task")
    object EditTask : NavigationItems("edit_task")
    object CreateAlarm : NavigationItems("create_alarm")
    object EditAlarm : NavigationItems("edit_alarm")
    object Profile : NavigationItems("profile")
    object UserLogin : NavigationItems("user_login")
    object UserRegistration : NavigationItems("user_registration")

}