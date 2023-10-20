package com.example.kitsu.di

import com.example.kitsu.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Объекты модуля (классы с аннотацией @Module) в Kotlin используются для предоставления
// и настройки зависимостей (например, объектов или сервисов),
// которые нужны в вашем Android-приложении.
// Они помогают сделать ваш код более организованным, модульным и легко тестируемым.
@Module
// @InstallIn(SingletonComponent::class) означает, что в модуле могут проводиться (@Provides)
// только те классы / интерфейсы (и тд), которые должны существовать в приложении в единственном экземпляре.
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    // инициализация класса retrofit
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    // знак "=" в котлине, означает, что функции или переменной нужно дать значение.
    // создаем функцию для api service и даем ему значение, обращаясь к retrofit
    fun provideAnimeApiService() = retrofitClient.provideAnimeApiService()
}