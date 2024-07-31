
package com.muscicek.composedaggerretrofit.data.remote


import com.muscicek.composedaggerretrofit.data.responses.Pokemon
import com.muscicek.composedaggerretrofit.data.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query(value = "limit") limit: Int,

        @Query(value = "offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String,
    ): Pokemon
}