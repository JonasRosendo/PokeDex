package com.example.pokedex.mvp

import com.example.pokedex.model.Pokemon
import retrofit2.Callback

interface PokemonRepositoryContract {
    fun getPokemons(callback: Callback<Pokemon>)
}