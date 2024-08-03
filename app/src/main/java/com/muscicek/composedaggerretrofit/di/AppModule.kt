package com.muscicek.composedaggerretrofit.di
import com.muscicek.composedaggerretrofit.data.remote.PokeApi
import com.muscicek.composedaggerretrofit.repository.PokemonRepository
import com.muscicek.composedaggerretrofit.util.Constants
import dagger.Module
import dagger.Provides

import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providePokemonRepository(api: PokeApi) = PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokeApi():  PokeApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL).build().create( PokeApi::class.java)
    }

}