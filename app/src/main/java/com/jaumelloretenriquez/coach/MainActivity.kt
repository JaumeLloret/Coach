package com.jaumelloretenriquez.coach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jaumelloretenriquez.coach.signin.presentation.SignInScreen
import com.jaumelloretenriquez.coach.signin.presentation.SignInViewModel
import com.jaumelloretenriquez.coach.signup.presentation.SignUpScreen
import com.jaumelloretenriquez.coach.ui.routes.Routes.*
import com.jaumelloretenriquez.coach.ui.theme.BackgroundArea
import com.jaumelloretenriquez.coach.ui.theme.BackgroundAreaReverse
import com.jaumelloretenriquez.coach.ui.theme.CoachTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val signInViewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoachTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = SignInScreen.route) {
                        composable(SignInScreen.route) {
                            BackgroundArea()
                            SignInScreen(navController, signInViewModel = signInViewModel)
                        }
                        composable(SignUpScreen.route) {
                            BackgroundAreaReverse()
                            SignUpScreen(navController)
                        }
                        /*composable(
                            HomeScreen.route,
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


@Composable
fun HomeScreen(id: Int, username: String, navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Es la pantalla principal $id, ->$username<-")
    }
}