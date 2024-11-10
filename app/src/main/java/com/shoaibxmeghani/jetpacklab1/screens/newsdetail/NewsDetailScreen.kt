package com.shoaibxmeghani.jetpacklab1.screens.newslist.viewmodel

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.shoaibxmeghani.jetpacklab1.screens.newsdetail.viewmodel.NewsDetailVM

@Composable
fun NewsDetailScreen() {

    val detailViewModel: NewsDetailVM = hiltViewModel()
    val detailUI = detailViewModel.uiState.collectAsState()

    Text(text = detailUI.value.title)



}