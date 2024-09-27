package com.farhan.bengkelnews.ui.screen.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farhan.bengkelnews.ViewModelFactory
import com.farhan.bengkelnews.data.BengkelRepository
import com.farhan.bengkelnews.model.Bengkel
import com.farhan.bengkelnews.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: BengkelRepository) : ViewModel(
) {
    private val _uiState = MutableStateFlow<UiState<List<Bengkel>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Bengkel>>> get() = _uiState

    fun getBengkel() {
        viewModelScope.launch {
            try {
                val bengkelList =
                    repository.getBengkel()
                _uiState.value = UiState.Success(bengkelList)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "An error occurred")
            }
        }
    }
}
