package com.example.kitsu.data.remote.apiservice

import com.example.kitsu.model.DataItem
import com.example.kitsu.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface AnimeApiService {

    // api service - интерфейс, внутри которого делается запрос на сервер
    @GET("edge/anime")
    suspend fun fetchAnime(): Response<DataItem>
}