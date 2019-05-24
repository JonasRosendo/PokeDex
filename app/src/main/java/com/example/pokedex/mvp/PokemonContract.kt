package com.example.pokedex.mvp

import com.example.pokedex.model.Pokemon

interface PokemonContract {

    interface View{
        fun onPokemonPageReady(pokemons: List<Pokemon>)
        fun onPokemonUpdatedList()
    }

    interface Presenter{
        fun onPokemonSearch()
        fun attach(view : View)
        fun detach()
    }
}