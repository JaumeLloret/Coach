package com.jaumelloretenriquez.coach.signin.data

import com.jaumelloretenriquez.coach.signin.data.network.SignInService
import javax.inject.Inject

class SignInRepository @Inject constructor(private val api: SignInService) {

    suspend fun doSignIn(user: String, password: String): Boolean = api.doSignIn(user, password)
}