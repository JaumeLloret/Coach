package com.jaumelloretenriquez.coach.signin.data.network

import com.jaumelloretenriquez.coach.core.security.PasswordHash
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class SignInService @Inject constructor(
    private val client: SignInClient,
    private val crypto: PasswordHash
) {

    suspend fun doSignIn(user: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val (hash, salt) = crypto.getCryptoPassword(password)
            val response = client.doSignIn(/*user, hash, salt*/)

            !response.body()?.name.isNullOrEmpty()
        }
    }
}