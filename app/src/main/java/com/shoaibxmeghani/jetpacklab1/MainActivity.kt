package com.shoaibxmeghani.jetpacklab1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shoaibxmeghani.jetpacklab1.api.NewsAPI
import com.shoaibxmeghani.jetpacklab1.screens.newslist.viewmodel.NewsDetailScreen
import com.shoaibxmeghani.jetpacklab1.screens.newslist.viewmodel.NewsListScreen
import com.shoaibxmeghani.jetpacklab1.ui.theme.Jetpacklab1Theme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var newsAPI: NewsAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //Greeting("Android")
            Jetpacklab1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}
@Composable
fun App(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "newslist" ){
      composable(route = "newslist") {
          NewsListScreen {
              navController.navigate("newsdetail/${it}")
          }
      }
      composable("newsdetail/{ntitle}",
          arguments = listOf(navArgument("ntitle"){
              type = NavType.StringType
          })
      ) {
          NewsDetailScreen()
      }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpacklab1Theme {
        Greeting("Android!")
    }
}