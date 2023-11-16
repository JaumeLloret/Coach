package com.jaumelloretenriquez.coach.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import javax.inject.Inject

 class HomeScreen @Inject constructor(
    private val homeViewModel: HomeViewModel
) {

    @Composable
    operator fun invoke(id: Int, username: String, navController: NavHostController) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Es la pantalla principal $id, ->$username<-")
        }
    }

}