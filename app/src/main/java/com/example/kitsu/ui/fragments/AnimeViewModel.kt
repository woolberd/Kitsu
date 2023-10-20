package com.example.kitsu.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.kitsu.data.remote.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    // инициализация класса AnimeRepository за пределами класса AnimeViewModel,
    // для того, чтобы не перегружать класс AnimeViewModel
    private val animeRepository: AnimeRepository
): ViewModel() {

    // знак "=" в котлине, означает, что функции или переменной нужно дать значение.
    // В этом коде, мы передали значение для fetchAnime() в классе AnimeViewModel из класса
    // AnimeRepository
    fun fetchAnime() = animeRepository.fetchAnime()
}