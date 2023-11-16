package com.jaumelloretenriquez.coach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jaumelloretenriquez.coach.core.routes.Routes
import com.jaumelloretenriquez.coach.signin.presentation.SignInScreen
import com.jaumelloretenriquez.coach.signin.presentation.SignInViewModel
import com.jaumelloretenriquez.coach.signup.presentation.SignUpScreen
import com.jaumelloretenriquez.coach.core.routes.Routes.*
import com.jaumelloretenriquez.coach.ui.theme.BackgroundArea
import com.jaumelloretenriquez.coach.ui.theme.BackgroundAreaReverse
import com.jaumelloretenriquez.coach.ui.theme.BackgroundCourt
import com.jaumelloretenriquez.coach.ui.theme.CoachTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : ComponentActivity() {
    private val signInViewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoachTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.SignInScreen.route) {
                        composable(Routes.SignInScreen.route) {
                            BackgroundArea()
                            SignInScreen(navController, signInViewModel = signInViewModel)
                        }
                        composable(Routes.SignUpScreen.route) {
                            BackgroundAreaReverse()
                            SignUpScreen(navController)
                        }
                        /*composable(
                            Routes.HomeScreen.route,
                            arguments = listOf(
                                navArgument("id") { type = NavType.IntType },
                                navArgument("username") {
                                    defaultValue = ""
                                })
                        ) {
                            BackgroundCourt()
                            HomeScreen(
                                navController = navController,
                                id = it.arguments?.getInt("id") ?: 0,
                                username = it.arguments?.getString("username").orEmpty()
                            )
                        }*/
                    }
                }
            }
        }
    }
}