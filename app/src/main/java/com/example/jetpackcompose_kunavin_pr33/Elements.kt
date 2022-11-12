package com.example.jetpackcompose_kunavin_pr33

import android.app.Activity
import android.content.res.Resources
import android.view.ContextThemeWrapper
import android.widget.CalendarView
import android.window.OnBackInvokedCallback
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose_kunavin_pr33.fragments.EditAlarmFragment
import com.example.jetpackcompose_kunavin_pr33.ui.theme.*


//Список дел :)
val messages:List<MessageItem> = listOf(
    MessageItem("Вечерний поход в кино", "Идем в кино с коллегами!", "10.02.2021", "19:40"),
    MessageItem("Забрать заказ Ozon", "Пункт выдачи на ул. Ленина, 103", "10.02.2021", "19:40"),
    MessageItem("Запись в автосервис", "Сдать автомобиль в автосервис на ул." + "Бисертская, д. 14. Замена масла", "10.02.2021", "19:40"),
)


//Добавление нижнего меню
@Composable
fun AddBottomMenu(navController: NavController){
    val listFragments = listOf(
        NavigationItems.List,
        NavigationItems.Alarm,
        NavigationItems.Calendar,
        NavigationItems.Settings
    )
    Card(modifier = Modifier
        .padding(start = 38.dp, end = 38.dp)
        .size(528.dp, 78.dp)
        .background(Green),
        shape = RoundedCornerShape(
            topEnd = 24.dp,
            topStart = 24.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        )
    )
    {
        BottomNavigation(
            modifier = Modifier.border(2.dp, Color.Black.copy(alpha = 0.3f), RoundedCornerShape(
                topEnd = 24.dp,
                topStart = 24.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            )),
            backgroundColor = LightGreen,
            contentColor = Color.White
        ) {
            listFragments.forEach{ item ->
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                    label = { Text(text = item.title) },
                    selected = false,
                    selectedContentColor = Green,
                    unselectedContentColor = Red,
                    alwaysShowLabel = true,
                    onClick = {
                        navController.navigate(item.route){
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

//Отображение задачи
@Composable
fun ElementViewTask(navController: NavController, msg:MessageItem, navigateItem:NavigationItems){
    Card(modifier = Modifier
        .size(428.dp, 108.dp)
        .clickable (
            onClick = {
                navController.navigate(navigateItem.route){
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
        .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 12.dp), shape = RoundedCornerShape(
        topEnd = 0.dp,
        topStart = 24.dp,
        bottomStart = 0.dp,
        bottomEnd = 24.dp
    ), elevation = 8.dp)
    {
        Row(modifier = Modifier
            .size(428.dp, 108.dp)
            .background(Color(Yellow.value))
            .padding(start = 28.dp, top = 16.dp, bottom = 8.dp)) {
            Column(modifier = Modifier.size(244.dp, 88.dp)) {
                Text(text = msg.title, style = TextStyle(fontSize = 18.sp, color = Color.White))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = msg.description, style = TextStyle(fontSize = 13.sp, color = LightGray))
            }
            Column(modifier = Modifier.size(108.dp, 88.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = msg.date, style = TextStyle(fontSize = 18.sp, color = LightGray))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = msg.time, style = TextStyle(fontSize = 13.sp, color = LightGray))
            }
        }
    }
}

//Отображение нескольких задач из листа
@Composable
fun Conversation(navController: NavController, messages: List<MessageItem>, navigateItem:NavigationItems) {
    LazyColumn{
        messages.map { item { ElementViewTask(navController, it, navigateItem) } }
    }
}

//Добавить кнопку с заданием параметров
@Composable
fun AddButton(navController: NavController, name:String, color: Color, textSize: Int, paddingTop:Int, navigateItem:NavigationItems){
    Row(modifier = Modifier
        .padding(bottom = 4.dp, top = paddingTop.dp, start = 32.dp, end = 32.dp)
        .size(428.dp, 58.dp))
    {
        Button(
            onClick = {
                navController.navigate(navigateItem.route){
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            colors = ButtonDefaults.buttonColors(color),
            modifier = Modifier
                .fillMaxWidth()
                .size(348.dp, 54.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        {
            Text(text = name, style = TextStyle(color = Color.White, fontSize = textSize.sp))
        }
    }
}

//Задание шапки для activity
@Composable
fun GeneralActivityHead(navController: NavController ,name:String, paintRes:Int, fontSize:Int, imageSize:Int, paddingStart: Int, navigateItem: NavigationItems = NavigationItems.List){
    Row(modifier = Modifier
        .padding(bottom = 28.dp, top = 4.dp, start = 4.dp, end = 4.dp)
        .size(428.dp, 78.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = name, style = TextStyle(color = Color.White, fontSize = fontSize.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center), modifier = Modifier.padding(paddingStart.dp, 0.dp, 0.dp, 8.dp))
        Image(painter = painterResource(id = paintRes),
            contentDescription = "Avatar",
            modifier = Modifier
                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                .size(imageSize.dp)
                .clip(CircleShape)
                .clickable(
                    enabled = true,
                    onClick = {
                        navController.navigate(
                            route = when (paintRes) {
                                R.drawable.avatar -> NavigationItems.Profile.route
                                else -> navigateItem.route
                            }
                        )
                    }
                ))
    }
}

@Composable
fun AddSwitch(navController: NavController, time:String, navigateItem:NavigationItems){
    Row(modifier = Modifier
        .padding(bottom = 8.dp, top = 4.dp, start = 4.dp, end = 18.dp)
        .size(428.dp, 68.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = time,
            style = TextStyle(color = Color.White,
                fontSize = 48.sp,
                textAlign = TextAlign.Center),
            modifier = Modifier.padding(28.dp, 0.dp, 0.dp, 8.dp).clickable(
                onClick = {
                    navController.navigate(navigateItem.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            ))
        val checkedState = remember { mutableStateOf(false) }
        Switch( checked = checkedState.value,
            modifier = Modifier
                .size(64.dp, 32.dp)
                .background(
                    color = if (checkedState.value) {
                        LightGreen
                    } else {
                        Red
                    },
                    shape = RoundedCornerShape(25.dp)
                )
                .padding(bottom = 2.dp, top = 2.dp),
            onCheckedChange = {checkedState.value = it},
            colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = LightGreen,
            uncheckedThumbColor = Color.White,
            uncheckedTrackColor = Red
        ))
    }
}

@Composable
fun AddCalendar(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(factory = {CalendarView(it)},
            update = {
            it.setOnDateChangeListener{ calendarView, year, month, day ->
            }
        }, modifier = Modifier.wrapContentSize())
    }
}

@Composable
fun AddSettingsElement(name:String){
    Row(modifier = Modifier
        .size(428.dp, 62.dp)
        .background(Green)
        .padding(bottom = 18.dp, start = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = name,
            style = TextStyle(color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Center))
        Image(painter = painterResource(id = R.drawable.arrow), contentDescription = "settings", modifier = Modifier.padding(top = 8.dp, end = 18.dp))
    }
}

@Composable
fun AddProfileIcon(){
    Column(modifier = Modifier.size(428.dp, 288.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.avatar), contentDescription = "avatar", Modifier.size(248.dp, 248.dp))
        Text(text = "Вход не выполнен", style = TextStyle(color = Color.White, fontSize = 18.sp), modifier = Modifier.padding(top = 18.dp))
    }
}

@Composable
fun AddTextField(hint: String, sizeWidth: Dp, sizeHeight: Dp, singleLine:Boolean = true){
    val message = remember{mutableStateOf("")}
    OutlinedTextField(
        modifier = Modifier
            .size(sizeWidth, sizeHeight)
            .padding(horizontal = 8.dp),
        value = message.value,
        onValueChange =  { message.value = it },
        textStyle = TextStyle(color = Color.Gray, fontSize = 16.sp),
        placeholder = { Text(hint, style = TextStyle(color = Color.Gray, fontSize = 16.sp))},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = LightGray,
            backgroundColor = Color.White,
            leadingIconColor = Color.Gray,
            cursorColor = Color.Gray
        ),
        singleLine = singleLine
    )
}
@Composable
fun AddTextFieldIcon(hint: String, sizeWidth: Dp, sizeHeight: Dp, icon: Int = -1, singleLine:Boolean = true){
    val message = remember{mutableStateOf("")}
    OutlinedTextField(
        modifier = Modifier
            .size(sizeWidth, sizeHeight)
            .padding(horizontal = 8.dp),
        value = message.value,
        onValueChange =  { message.value = it },
        textStyle = TextStyle(color = Color.Gray, fontSize = 16.sp),
        placeholder = { Text(hint, style = TextStyle(color = Color.Gray, fontSize = 16.sp))},
        leadingIcon = { if(icon != -1) Icon(modifier = Modifier.size(20.dp,20.dp), painter = painterResource(id = icon), contentDescription = "date") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = LightGray,
            backgroundColor = Color.White,
            leadingIconColor = Color.Gray,
            cursorColor = Color.Gray
        ),
        singleLine = singleLine
    )
}

var list = listOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье")

@Composable
fun AddCheckBox(name:String){
    val checkedState = remember { mutableStateOf(false) }
    Row(modifier = Modifier
        .size(198.dp, 48.dp)
        .background(Green)
        .padding(start = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Yellow,
                uncheckedColor = Yellow,
                checkmarkColor = Red
            ),
            modifier = Modifier
                .background(Color.White)
                .size(18.dp)
        )
        Text(text = name, style = TextStyle(fontSize = 18.sp, color = Color.White), modifier = Modifier.padding(start = 18.dp))
    }
}

@Composable
fun AddCheckBoxes(list:List<String>){
    Column(modifier = Modifier.size(208.dp, 368.dp).background(Green), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Повторять каждый:", style = TextStyle(fontSize = 18.sp, color = Color.White), modifier = Modifier.padding(end = 28.dp))
        LazyColumn {
            list.map { item { AddCheckBox(it) } }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackCompose_Kunavin_PR33Theme {
        AddCheckBoxes(list)
    }
}