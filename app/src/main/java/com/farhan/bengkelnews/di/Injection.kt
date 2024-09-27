package com.farhan.bengkelnews.di


import com.farhan.bengkelnews.data.BengkelRepository

object Injection {
    fun provideRepository(): BengkelRepository {
        return BengkelRepository.getInstance()
    }
}