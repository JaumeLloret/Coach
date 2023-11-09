package com.jaumelloretenriquez.coach.signin.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class SignInService @Inject constructor(
    private val client: SignInClient
) {

    suspend fun doSignIn(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = client.doSignIn(/*user, password*/)

            !response.body()?.name.isNullOrEmpty()
        }
    }
}