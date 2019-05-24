package com.example.pokedex.mvp

import com.example.pokedex.model.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonPresenter : PokemonContract.Presenter {

    private var view : PokemonContract.View? = null
    private val pokemonRepository: PokemonRepositoryContract = PokemonRepository()
    private val pokemonsDetails = mutableListOf<Pokemon>()


    override fun onPokemonSearch() {
        view?.onPokemonPageReady(pokemonsDetails)

        val callback = getPokemonDetailsCallBack()
        pokemonRepository.getPokemons(callback)
    }

    private fun getPokemonDetailsCallBack(): Callback<Pokemon> {

        return object : Callback<Pokemon>{
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {

                if(response.isSuccessful){
                    val pokemon : Pokemon? = response.body()
                    addPokemonToList(pokemon)
                    view?.onPokemonUpdatedList()
                }
            }

            private fun addPokemonToList(pokemon: Pokemon?) {
                pokemon?.let {
                    var position = 0
                    pokemonsDetails.forEach { otherPokemon ->
                        if (pokemon.id < otherPokemon.id) {
                            return@forEach
                        }
                        position++
                    }
                    pokemonsDetails.add(position, pokemon)
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    override fun attach(view: PokemonContract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }
}


