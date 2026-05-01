package com.saurav.newsapp_mvvm_architecture.ui.theme.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.saurav.newsapp_mvvm_architecture.ui.theme.topHeadlines.TopHeadlinesScreen

sealed class Screen(val route: String) {
    object TopHeadlines : Screen("top_headlines")


}

