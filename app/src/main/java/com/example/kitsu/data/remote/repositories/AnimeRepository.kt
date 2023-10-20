package com.example.kitsu.data.remote.repositories

import androidx.lifecycle.liveData
import com.example.kitsu.data.remote.apiservice.AnimeApiService
import com.example.kitsu.utils.Resource
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    // инициализация интерфейса AnimeApiService за пределами класса AnimeRepository,
    // для того, чтобы не перегружать класс AnimeRepository
    private val animeApiService: AnimeApiService
){
    //  данный код обрабатывает данные и ловит ошибки, если они появятся работая в реальном времени
    fun fetchAnime() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(animeApiService.fetchAnime()))
        }catch (exception: Exception){
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}