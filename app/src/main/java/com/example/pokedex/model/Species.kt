package com.example.pokedex.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Species {
    @SerializedName("name")
    @Expose
    private val name: String? = null
    @SerializedName("url")
    @Expose
    private val url: String? = null
}