package com.jaumelloretenriquez.coach.signin.data.network

import com.jaumelloretenriquez.coach.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SignInService {
    private val retrofit = RetrofitHelper.getRetrofitMock()

    suspend fun doSignIn(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(SignInClient::class.java).doSignIn(/*user, password*/)

            !response.body()?.name.isNullOrEmpty()
        }
    }
}