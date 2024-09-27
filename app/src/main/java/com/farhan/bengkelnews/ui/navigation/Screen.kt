package com.farhan.bengkelnews.ui.navigation

sealed class Screen(val route: String) {
    object News : Screen("news")
    object Profile : Screen("profile")
    object DetailNews : Screen("home/{newsId}") {
        fun createRoute(newsId: Long) = "home/$newsId"
    }
}