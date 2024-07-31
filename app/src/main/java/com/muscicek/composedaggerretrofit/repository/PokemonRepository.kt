
package com.muscicek.composedaggerretrofit.repository

import com.muscicek.composedaggerretrofit.data.remote.PokeApi
import com.muscicek.composedaggerretrofit.data.responses.Pokemon
import com.muscicek.composedaggerretrofit.data.responses.PokemonList
import com.muscicek.composedaggerretrofit.util.Resource
import dagger.hilt.android.scopes.ActivityScoped

import javax.inject.Inject



class PokemonRepository @Inject constructor(private val api: PokeApi) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        var response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(message = "Hata meydana geldi")
        }
        return Resource.Success(response)
    }
    suspend fun getPokemonInfo(pokemonName:String): Resource<Pokemon> {
        var response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error(message = "Hata meydana geldi")
        }
        return Resource.Success(response)
    }
}