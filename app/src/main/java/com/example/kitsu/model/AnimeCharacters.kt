package com.example.kitsu.model

import com.google.gson.annotations.SerializedName

data class AnimeCharacters(@SerializedName("links")
                           val links: Links)