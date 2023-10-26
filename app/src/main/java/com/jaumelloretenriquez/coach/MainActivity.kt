package com.jaumelloretenriquez.coach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.jaumelloretenriquez.coach.signin.ui.SignInScreen
import com.jaumelloretenriquez.coach.signin.ui.SignInViewModel
import com.jaumelloretenriquez.coach.ui.background.BackgroundArea
import com.jaumelloretenriquez.coach.ui.background.BackgroundAreaReverse
import com.jaumelloretenriquez.coach.ui.background.BackgroundCourt
import com.jaumelloretenriquez.coach.ui.theme.CoachTheme

class MainActivity : ComponentActivity() {
    private val signInViewModel = SignInViewModel();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoachTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BackgroundArea()
                    SignInScreen(signInViewModel = signInViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoachTheme {
        BackgroundAreaReverse()
        Greeting("Android")
    }
}