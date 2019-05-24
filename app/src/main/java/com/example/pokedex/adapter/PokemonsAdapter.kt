package com.example.pokedex.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokedex.R
import com.example.pokedex.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.pokemons_adapter.*

class PokemonsAdapter(private val pokemons: List<Pokemon>) : RecyclerView.Adapter<PokemonsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.pokemons_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = pokemons.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.tvPokemonName.text = pokemon.name

        holder.tvPokemonNumber.text = "#" + pokemons[position].id.toString()
        Picasso.get().load(pokemons[position].sprites?.frontDefault).into(holder.ivPokemonSprite)
    }


    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer

}


