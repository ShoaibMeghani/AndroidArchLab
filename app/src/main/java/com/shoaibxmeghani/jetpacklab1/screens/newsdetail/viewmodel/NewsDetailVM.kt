package com.shoaibxmeghani.jetpacklab1.screens.newsdetail.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NewsDetailVM @Inject constructor(
    private val savedState: SavedStateHandle) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUIState())
    val uiState = _uiState.asStateFlow()

        init {
            val title = savedState.get<String>("ntitle") ?: "testing"
            _uiState.update {
                  it.copy(title=title)
            }
        }

}