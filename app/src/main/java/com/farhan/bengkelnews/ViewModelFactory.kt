package com.farhan.bengkelnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.farhan.bengkelnews.data.BengkelRepository
import com.farhan.bengkelnews.ui.screen.detail.DetailNewsViewModel
import com.farhan.bengkelnews.ui.screen.news.NewsViewModel

class ViewModelFactory(private val repository: BengkelRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailNewsViewModel::class.java)) {
            return DetailNewsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}