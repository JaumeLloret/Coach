package com.jaumelloretenriquez.coach.core.dependencyinjection

import com.jaumelloretenriquez.coach.signin.data.network.SignInClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    /*
    *
    * https://clutrtqceergafdtqjeb.supabase.co/auth/v1/token?grant_type=password
    * https://clutrtqceergafdtqjeb.supabase.co/rest/v1/dish?select=*
    *
    * */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://clutrtqceergafdtqjeb.supabase.co/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Singleton
    @Provides
    fun provideSignInClient(retrofit: Retrofit): SignInClient =
        retrofit.create(SignInClient::class.java)
}