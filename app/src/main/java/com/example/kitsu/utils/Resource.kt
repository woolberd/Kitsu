package com.example.kitsu.utils

// В языке программирования Kotlin sealed class - это особый тип класса,
// который часто используется для организации иерархии типов данных,
// которая может принимать ограниченное количество разных значений.
// Классы, объявленные с использованием sealed, могут быть полезными для создания алгоритмов
// обработки различных вариантов данных с использованием выражений when.
sealed class Resource<out T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String?, data: T? = null) : Resource<T>(data = data, message = message)
}
