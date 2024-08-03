package com.muscicek.composedaggerretrofit.pokemondetail

import androidx.lifecycle.ViewModel
import com.muscicek.composedaggerretrofit.data.responses.Pokemon
import com.muscicek.composedaggerretrofit.repository.PokemonRepository
import com.muscicek.composedaggerretrofit.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(private val repository: PokemonRepository) :
    ViewModel() {

        suspend fun getPokemonInfo(pokemonName:String):Resource<Pokemon>{

            return repository.getPokemonInfo(pokemonName)
        }

}