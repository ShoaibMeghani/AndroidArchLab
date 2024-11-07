package com.shoaibxmeghani.jetpacklab1.api

import com.shoaibxmeghani.jetpacklab1.models.NewsItem
import retrofit2.Response
import retrofit2.http.GET

interface NewsAPI {

    @GET("/v3/b/6728c1f0e41b4d34e44e319d?meta=false")
    suspend fun getNews() : Response<List<NewsItem>>
}