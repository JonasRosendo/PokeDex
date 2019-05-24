package com.example.pokedex.api

import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val BASE_URL = "https://pokeapi.co/api/v2/"
    var retrofit: Retrofit? = null

    fun getRetrofitClient(): Retrofit? {

        if(retrofit == null){
            retrofit = Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory
                    .create()).build()
        }

        return retrofit
    }

    fun getApiService() : ApiService? = getRetrofitClient()?.create(ApiService::class.java)
}