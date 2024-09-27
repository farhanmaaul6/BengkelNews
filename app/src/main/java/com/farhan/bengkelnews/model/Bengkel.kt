package com.farhan.bengkelnews.model

data class Bengkel(
    val id: Long,
    val title: String,
    val photoUrl: String,
    val type1 : String,
    val type2 : String,
    val description: String,
    val linkUrl: String,
) {
}
