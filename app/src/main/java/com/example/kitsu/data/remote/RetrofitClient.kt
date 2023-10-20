package com.example.kitsu.data.remote

import com.example.kitsu.data.remote.apiservice.AnimeApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    // OkHttpClient - ответ от сервера. Ниже прописывается логика, как и в течении какого времени
    // должен придти ответ
    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    // в Retrofit'e прописывается baseUrl и привязывается OkHttpClient
    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // Должны сначала провести api service и далее его вызвыть в module
    fun provideAnimeApiService() = retrofitClient.create(AnimeApiService::class.java)
 }