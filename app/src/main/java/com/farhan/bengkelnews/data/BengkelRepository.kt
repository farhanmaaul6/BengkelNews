package com.farhan.bengkelnews.data

import com.farhan.bengkelnews.model.Bengkel
import com.farhan.bengkelnews.model.BengkelData
import com.farhan.bengkelnews.model.BengkelData.dataBengkel

class BengkelRepository {
    fun getBengkel(): List<Bengkel> {
        return BengkelData.dataBengkel
    }

    fun getDataBengkelById(newsId: Long): Bengkel? {
        return dataBengkel.find { it.id == newsId }
    }

    companion object {
        @Volatile
        private var instance: BengkelRepository? = null

        fun getInstance(): BengkelRepository =
            instance ?: synchronized(this) {
                BengkelRepository().apply {
                    instance = this
                }
            }
    }

}