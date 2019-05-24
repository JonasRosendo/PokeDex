package com.example.pokedex.mvp

import com.example.pokedex.api.RetrofitClient
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonPage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository : PokemonRepositoryContract {

    private val client = RetrofitClient()
    private val apiService = client.getApiService()

    override fun getPokemons(callback: Callback<Pokemon>) {

        val searchPokemonsPreviewCall: Call<PokemonPage>? = apiService?.getPokemonFirstPage()

        val searchCallback = object : Callback<PokemonPage>{
            override fun onResponse(call: Call<PokemonPage>, response: Response<PokemonPage>) {
                if(response.isSuccessful) {

                    val pokemonPage : PokemonPage? = response.body()
                    pokemonPage?.pokemons?.forEach { pokemonResult ->
                        val pokemonName = pokemonResult.name
                        val getPokemonDetailCall: Call<Pokemon>? = apiService?.getPokemonsDetails(pokemonName)
                        getPokemonDetailCall?.enqueue(callback)
                    }

                }
            }

            override fun onFailure(call: Call<PokemonPage>, t: Throwable) {
                t.printStackTrace()
            }
        }
        searchPokemonsPreviewCall?.enqueue(searchCallback)
    }

}
