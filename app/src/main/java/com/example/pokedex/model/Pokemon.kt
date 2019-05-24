package com.example.pokedex.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Pokemon {
    @SerializedName("id")
    @Expose
    var id: Int = 0
    @SerializedName("abilities")
    @Expose
    val abilities: List<Ability>? = null
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("order")
    @Expose
    val order: Int? = 0
    @SerializedName("species")
    @Expose
    val species: Species? = null
    @SerializedName("sprites")
    @Expose
    val sprites: Sprites? = null
    @SerializedName("weight")
    @Expose
    val weight: Int? = null
}
