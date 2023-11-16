package com.jaumelloretenriquez.coach.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jaumelloretenriquez.coach.core.routes.Routes
import com.jaumelloretenriquez.coach.home.presentation.HomeScreen
import com.jaumelloretenriquez.coach.signin.presentation.SignInScreen
import com.jaumelloretenriquez.coach.signin.presentation.SignInViewModel
import com.jaumelloretenriquez.coach.signup.presentation.SignUpScreen
import com.jaumelloretenriquez.coach.ui.theme.BackgroundArea
import com.jaumelloretenriquez.coach.ui.theme.BackgroundAreaReverse
import com.jaumelloretenriquez.coach.ui.theme.BackgroundCourt
import javax.inject.Inject

class Navigator @Inject constructor(
    private val signInViewModel: SignInViewModel,
    private val homeScreen: HomeScreen
) {

    @Composable
    operator fun invoke() {

    }
}