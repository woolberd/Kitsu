package com.example.kitsu.model

import com.google.gson.annotations.SerializedName

data class Categories(@SerializedName("links")
                      val links: Links)