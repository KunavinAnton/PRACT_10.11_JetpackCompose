package com.example.jetpackcompose_kunavin_pr33

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose_kunavin_pr33.ui.theme.*


data class MessageItem(val title: String, val description: String, val date: String, val time: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val messages:List<MessageItem> = listOf(
            MessageItem("Вечерний поход в кино", "Идем в кино с коллегами!", "10.02.2021", "19:40"),
            MessageItem("Забрать заказ Ozon", "Пункт выдачи на ул. Ленина, 103", "10.02.2021", "19:40"),
            MessageItem("Запись в автосервис", "Сдать автомобиль в автосервис на ул." + "Бисертская, д. 14. Замена масла", "10.02.2021", "19:40"),
        )
        setContent {
            JetpackCompose_Kunavin_PR33Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(Modifier.background(Color(Green.value)), verticalArrangement = Arrangement.SpaceBetween) {
                        GeneralActivityHead("Список дел")
                        Conversation(messages)
                        AddButton(name = "Добавить задачу", color = Color(LightGreen.value), textSize = 22, paddingTop = 38)
                        AddBottomMenu()
                    }
                }
            }
        }
    }
}


@Composable
private fun Conversation(messages: List<MessageItem>) {
    LazyColumn {
        messages.map { item { ElementViewTask(it) } }
    }
}

@Composable
fun GeneralActivityHead(name:String){
        Row(modifier = Modifier
            .padding(bottom = 28.dp, top = 4.dp, start = 4.dp, end = 4.dp)
            .size(428.dp, 78.dp)
            , verticalAlignment = Alignment.CenterVertically){
            Text(text = name, style = TextStyle(color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center), modifier = Modifier.padding(28.dp, 0.dp, 0.dp, 8.dp))
            Image(painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Avatar",
                modifier = Modifier
                    .padding(start = 148.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                    .size(68.dp)
                    .clip(CircleShape))
        }
}

@Composable
fun AddButton(name:String, color: Color, textSize: Int, paddingTop:Int){
    Row(modifier = Modifier
        .padding(bottom = 4.dp, top = paddingTop.dp, start = 28.dp, end = 28.dp)
        .size(428.dp, 78.dp)) 
    {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(color),
            modifier = Modifier
                .fillMaxWidth()
                .size(348.dp, 48.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        {
            Text(text = name, style = TextStyle(color = Color.White, fontSize = textSize.sp))
        }  
    }
}

@Composable
fun AddBottomMenu(){
    Card(modifier = Modifier
        .padding(start = 38.dp, end = 38.dp)
        .size(428.dp, 78.dp),
        shape = RoundedCornerShape(
        topEnd = 24.dp,
        topStart = 24.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    ), elevation = 8.dp)
    {
        Row(modifier = Modifier
            .size(428.dp, 78.dp)
            .background(LightGreen))
        {

        }
    }
}

@Composable
fun ElementViewTask(msg:MessageItem){
    Card(modifier = Modifier
        .size(428.dp, 108.dp)
        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp), shape = RoundedCornerShape(
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackCompose_Kunavin_PR33Theme {
        ElementViewTask(MessageItem("123", "123", "123", "123"))
    }
}