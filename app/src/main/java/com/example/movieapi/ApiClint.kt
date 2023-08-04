package com.example.movieapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClint {
    companion object{
        lateinit var retrofit:Retrofit
        var base_url="https://api.themoviedb.org/3/"
        fun getclint(): Retrofit {
                    retrofit=Retrofit.Builder().baseUrl(base_url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            return retrofit
        }
    }
}