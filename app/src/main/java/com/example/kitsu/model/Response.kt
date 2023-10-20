package com.example.kitsu.model

import com.google.gson.annotations.SerializedName

data class Response<T>(
    // <T> Дженерики - позволяют создавать классы, интерфейсы и методы,
    // которые могут работать с различными типами данных,
    // без необходимости создания отдельной версии для каждого типа.
    @SerializedName("data")
    // аннотация @SerializedName("...") вместо точек прописываются поля моделек, для того, чтобы
    // сравнивать какие данные приходят с сервера и совпадают ли с нашими полями ( val ... : Тип данных )
    val data: List<T>?,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("links")
    val links: Links
)