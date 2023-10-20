package com.example.kitsu.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu.databinding.FragmentAnimeBinding
import com.example.kitsu.ui.adapter.AnimeAdapter
import com.example.kitsu.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment() {

    // инициализация binding
    private val binding by viewBinding(FragmentAnimeBinding::bind)
    // инициализация view model
    private val viewModel: AnimeViewModel by viewModels()
    // экземпляр класса adapter
    private val animeAdapter = AnimeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // создаем отдельные функции для прописания кода в них
        initialize()
        setupSubscribes()
    }

    private fun initialize() {
        // соединяем логику с дизайном
        binding.animeRecView.adapter = animeAdapter
    }

    private fun setupSubscribes() {
        // вызываем функцию с view model и далее отслеживаем ее через observe
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            when (it) {
//                is Resource.Error<*> -> {
//                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
//                }
//                is Resource.Loading<*> -> {
//                }
//                is Resource.Success<*> -> {
//                    it.data?.let { data ->
//                        animeAdapter.submitList(data.data)
//                    }
//                }
                is Resource.Error -> {
                    Log.e("aua", "setupSubscribes: ${it.message}", )
                }

                is Resource.Loading -> {}
                is Resource.Success -> {
                    // в адаптер добавляем модель с данными
                    it.data.let { data ->
                        animeAdapter.submitList(data?.data)
                    }
                }
            }
        }
    }
}