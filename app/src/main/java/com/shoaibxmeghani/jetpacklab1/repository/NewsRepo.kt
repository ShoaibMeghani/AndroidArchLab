package com.shoaibxmeghani.jetpacklab1.repository

import com.shoaibxmeghani.jetpacklab1.api.NewsAPI
import com.shoaibxmeghani.jetpacklab1.models.NewsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class NewsRepo @Inject constructor(private val newsAPI: NewsAPI){

    private val _newsList = MutableStateFlow<List<NewsItem>>(emptyList())
    val newsList: StateFlow<List<NewsItem>>
        get() = _newsList


    suspend fun getNews(){
        val response = newsAPI.getNews()
        if (response.isSuccessful && response.body() != null){
            _newsList.emit(response.body()!!)
        }
    }

}