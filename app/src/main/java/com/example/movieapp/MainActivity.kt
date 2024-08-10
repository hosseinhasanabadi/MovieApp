package com.example.movieapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp {
                MainContent()
            }

        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(content:@Composable ()-> Unit){
    MovieAppTheme {

       Scaffold (topBar = {
           TopAppBar(modifier = Modifier.fillMaxWidth(), colors = TopAppBarDefaults.topAppBarColors(
               containerColor =Color.Magenta ),

              // Modifier.shadow(elevation = 5.dp),
               title = {
               Text(text = "Movies",) }
           )

       },  content = { paddingValues ->
            // اینجا پدینگ را به محتوای اصلی اعمال می‌کنیم
           Box(modifier = Modifier.padding(paddingValues)) {
               MainContent()
           }
       }
       )
    }
}
@Composable
fun MainContent(movieList:List <String>  = listOf(
    "Avatar",
    "300",
    "Harry Potter",
    "Happiness...",
    "Cross th Line...",
    "be Happy...",
    "Happy Feet...",
    "Feat...",
    "Life"
)){
    Column (modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = movieList){
                MovieRow(movie =it ){movie->
                    Log.d("2525","Main $movie")


                }

            }
        }


    }



}
@Composable
fun MovieRow(movie:String,onItemClick:(String)->Unit={}){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp)
        .clickable {
                   onItemClick(movie)

        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row (verticalAlignment =Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start){
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp)
            , shape = RectangleShape
                , shadowElevation = 4.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox,
                    contentDescription = "movie IMage")

            }
            Text(text = movie)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {
        MainContent()
    }

}