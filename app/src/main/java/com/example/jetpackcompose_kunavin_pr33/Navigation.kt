package com.example.jetpackcompose_kunavin_pr33

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose_kunavin_pr33.fragments.*
import com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu.AlarmFragment
import com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu.CalendarFragment
import com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu.ListFragment
import com.example.jetpackcompose_kunavin_pr33.fragments_bottom_menu.SettingsFragment
import com.example.jetpackcompose_kunavin_pr33.ui.theme.Green
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(navController: NavHostController) {
    AnimatedNavHost(navController = navController, startDestination = NavigationItems.List.route){
        composable(route = NavigationItems.List.route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItems.Alarm.route ->  slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(200))
                    NavigationItems.Calendar.route ->  slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(200))
                    NavigationItems.Settings.route ->  slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(200))
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route){
                    NavigationItems.Alarm.route ->  slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
                    NavigationItems.Calendar.route ->  slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
                    NavigationItems.Settings.route ->  slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
                    else -> null
                }
            }
        ){
            ListFragment(navController = navController)
        }
        composable(route = NavigationItems.Alarm.route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItems.List.route ->  slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
                    NavigationItems.Calendar.route ->  slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(200))
                    NavigationItems.Settings.route ->  slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(200))
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route){
                    //NavigationItems.List.route ->  slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
                    NavigationItems.Calendar.route ->  slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
                    NavigationItems.Settings.route ->  slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
                    else -> null
                }
            }){
            AlarmFragment(navController = navController)
        }
        composable(route = NavigationItems.Calendar.route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItems.List.route ->  slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
                    NavigationItems.Settings.route ->  slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(200))
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route){
                    NavigationItems.Settings.route ->  slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
                    else -> null
                }
            }){
            CalendarFragment(navController = navController)
        }
        composable(route = NavigationItems.Settings.route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItems.List.route ->  slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(200))
                    //NavigationItems.Settings.route ->  slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(200))
                    else -> null
                }
            }){
            SettingsFragment(navController = navController)
        }

        composable(route = NavigationItems.EditTask.route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItems.List.route -> scaleIn(animationSpec = tween(200))
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route){
                    NavigationItems.List.route -> scaleOut(animationSpec = tween(200))
                    else -> null
                }
            }) {
            EditTaskFragment(navController = navController)
        }
        composable(route = NavigationItems.AddTask.route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItems.List.route -> scaleIn(animationSpec = tween(200))
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route){
                    NavigationItems.List.route -> scaleOut(animationSpec = tween(200))
                    else -> null
                }
            }) {
            AddTaskFragment(navController = navController)
        }
        composable(route = NavigationItems.UserLogin.route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItems.Profile.route -> scaleIn(animationSpec = tween(200))
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route){
                    NavigationItems.Profile.route -> scaleOut(animationSpec = tween(200))
                    else -> null
                }
            }) {
            UserLoginFragment(navController = navController)
        }
        composable(route = NavigationItems.UserRegistration.route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItems.Profile.route -> scaleIn(animationSpec = tween(200))
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route){
                    NavigationItems.Profile.route -> scaleOut(animationSpec = tween(200))
                    else -> null
                }
            }) {
            UserRegistrationFragment(navController = navController)
        }
        composable(route = NavigationItems.EditAlarm.route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItems.Alarm.route -> scaleIn(animationSpec = tween(200))
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route){
                    NavigationItems.Alarm.route -> scaleOut(animationSpec = tween(200))
                    else -> null
                }
            }) {
            EditAlarmFragment(navController = navController)
        }
        composable(route = NavigationItems.CreateAlarm.route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItems.Alarm.route -> scaleIn(animationSpec = tween(200))
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route){
                    NavigationItems.Alarm.route -> scaleOut(animationSpec = tween(200))
                    else -> null
                }
            }) {
            CreateAlarmFragment(navController = navController)
        }
        composable(route = NavigationItems.Profile.route,
            enterTransition = {
                when(initialState.destination.route){
                    NavigationItems.List.route,
                    NavigationItems.Alarm.route,
                    NavigationItems.Calendar.route,
                    NavigationItems.Settings.route -> scaleIn(animationSpec = tween(200))
                    else -> null
                }
            },
            exitTransition = {
                when(targetState.destination.route){
                    NavigationItems.List.route -> scaleOut(animationSpec = tween(200))
                    else -> null
                }
            }) {
            ProfileFragment(navController = navController)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(){
    val navController = rememberAnimatedNavController()
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    showBottomBar = when (navBackStackEntry?.destination?.route) {
        NavigationItems.List.route,
        NavigationItems.Alarm.route,
        NavigationItems.Calendar.route,
        NavigationItems.Settings.route -> true
        else -> false
    }
    Scaffold(
        bottomBar = { if (showBottomBar) AddBottomMenu(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController)
            }
        },
        backgroundColor = Green
    )
}