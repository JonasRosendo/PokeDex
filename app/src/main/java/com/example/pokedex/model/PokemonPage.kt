package com.example.pokedex.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PokemonPage {
    @SerializedName("count")
    @Expose
    private var count: Int = 0
    @SerializedName("next")
    @Expose
    private var next:String = ""
    @SerializedName("previous")
    @Expose
    private var previous:String = ""

    @SerializedName("results")
    @Expose
    var pokemons: ArrayList<Pokemon>? = null
}
