package com.farhan.bengkelnews.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farhan.bengkelnews.data.BengkelRepository
import com.farhan.bengkelnews.model.Bengkel
import com.farhan.bengkelnews.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailNewsViewModel(
    private val repository: BengkelRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<List<Bengkel>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Bengkel>>> get() = _uiState

    fun getBengkelById(newsId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            val bengkel = repository.getDataBengkelById(newsId)

            if (bengkel != null) {
                _uiState.value = UiState.Success(listOf(bengkel))
            } else {
                _uiState.value = UiState.Error("Bengkel not found")
            }
        }
    }
}

