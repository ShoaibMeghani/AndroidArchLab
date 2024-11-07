package com.shoaibxmeghani.jetpacklab1.screens.newslist.viewmodel

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shoaibxmeghani.jetpacklab1.models.NewsItem
import com.shoaibxmeghani.jetpacklab1.ui.theme.Jetpacklab1Theme


@Composable
fun NewsListScreen(){

    val newsListVM: NewsListVM = viewModel()
    val list = newsListVM.newsList.collectAsState()

    LazyColumn(content = {
        items(list.value){
            NewsListItem(item = it)
        }
    })

}

@Composable
fun NewsListItem(item: NewsItem) {

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {

            Column {
                Text(
                    text = item.title,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 22.sp)

                Text(
                    text = item.source,
                    modifier = Modifier.padding(10.dp),
                    fontSize = 22.sp)
            }

        }
    )

}

@Preview(showBackground = true)
@Composable
fun NewsListScreenPreview() {
    Jetpacklab1Theme {

         val item = NewsItem("source","news title")

        NewsListItem(item)
    }



}
