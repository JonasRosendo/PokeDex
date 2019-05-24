package com.example.pokedex.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.pokedex.R
import com.example.pokedex.adapter.PokemonsAdapter
import com.example.pokedex.model.Pokemon
import com.example.pokedex.mvp.PokemonContract
import com.example.pokedex.mvp.PokemonPresenter
import kotlinx.android.synthetic.main.fragment_pokemons.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PokemonsFragment : Fragment(), PokemonContract.View {

    var presenter : PokemonContract.Presenter = PokemonPresenter()
    var adapterPokemons : PokemonsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_pokemons, container, false)

        presenter.attach(this@PokemonsFragment)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerPokemons.layoutManager = GridLayoutManager(view.context, 2)

        presenter.onPokemonSearch()
    }

    override fun onPokemonPageReady(pokemons: List<Pokemon>) {
        adapterPokemons = PokemonsAdapter(pokemons)
        recyclerPokemons.adapter = adapterPokemons
    }

    override fun onPokemonUpdatedList() {
        adapterPokemons?.notifyDataSetChanged()
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }
}
