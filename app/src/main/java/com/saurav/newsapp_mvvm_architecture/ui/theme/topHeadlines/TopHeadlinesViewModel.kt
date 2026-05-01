package com.saurav.newsapp_mvvm_architecture.ui.theme.topHeadlines

import android.provider.ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saurav.newsapp_mvvm_architecture.data.model.Article
import com.saurav.newsapp_mvvm_architecture.data.model.Country
import com.saurav.newsapp_mvvm_architecture.data.repository.TopHeadLineRepository
import com.saurav.newsapp_mvvm_architecture.di.module.BackgroundContext
import com.saurav.newsapp_mvvm_architecture.ui.theme.base.UiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class TopHeadlinesViewModel @Inject constructor(
    private val repository: TopHeadLineRepository,
    @BackgroundContext private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Article>>>(
        UiState.Initial
    )
    private val uiState: StateFlow<UiState<List<Article>>> = _uiState

    fun loadTopHeadlines(country: String = "us") {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            repository.getTopHeadLine(country).onStart {
                _uiState.value = UiState.Loading
            }.catch {
                _uiState.value = UiState.Error(it.message)
            }.flowOn(dispatcher).collect { articles ->
                _uiState.value = UiState.Success(articles)
            }
        }

    }


}
