package com.saurav.newsapp_mvvm_architecture.data.repository

import com.saurav.newsapp_mvvm_architecture.data.model.Language
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LanguageRepository @Inject constructor() {
    fun getLanguage(): Flow<List<Language>> = flow{
        emit(languagesList)
    }


    companion object {
        val languagesList = listOf(
            Language("en", "English", "English", "🇬🇧"),
            Language("es", "Spanish", "Español", "🇪🇸"),
            Language("fr", "French", "Français", "🇫🇷"),
            Language("de", "German", "Deutsch", "🇩🇪"),
            Language("hi", "Hindi", "हिंदी", "🇮🇳"),
            Language("ar", "Arabic", "العربية", "🇸🇦"),
            Language("zh", "Chinese", "中文", "🇨🇳"),
            Language("ja", "Japanese", "日本語", "🇯🇵"),
            Language("ru", "Russian", "Русский", "🇷🇺"),
            Language("pt", "Portuguese", "Português", "🇵🇹")
        )
    }
}