package com.jaumelloretenriquez.coach.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    //Test Local
    fun getRetrofit(): Retrofit = Retrofit.Builder().baseUrl("http://localhost:3000/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    //Test Online
    fun getRetrofitMock(): Retrofit = Retrofit.Builder().baseUrl("https://run.mocky.io/")
        .addConverterFactory(GsonConverterFactory.create()).build()
}