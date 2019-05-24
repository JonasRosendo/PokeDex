package com.example.pokedex.api

import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonPage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("pokemon")
    fun getPokemonFirstPage():Call<PokemonPage>

    @GET("pokemon/{pokemonName}")
    fun getPokemonsDetails(@Path("pokemonName") pokemonName: String?) : Call<Pokemon>



}