package com.saurav.newsapp_mvvm_architecture.di.module

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BackgroundContext

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainContext