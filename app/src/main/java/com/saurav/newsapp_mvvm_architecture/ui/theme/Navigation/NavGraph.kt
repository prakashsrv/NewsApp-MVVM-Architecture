package com.saurav.newsapp_mvvm_architecture.ui.theme.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saurav.newsapp_mvvm_architecture.ui.theme.Navigation.Screen.TopHeadlines
import com.saurav.newsapp_mvvm_architecture.ui.theme.topHeadlines.TopHeadlinesScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier   // ← accept modifier
) {
    NavHost(
        navController = navController,
        startDestination = TopHeadlines.route,
        modifier = modifier           // ← apply it here
    ) {
        composable(TopHeadlines.route) {
            TopHeadlinesScreen()
        }
    }
}