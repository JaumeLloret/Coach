package com.jaumelloretenriquez.coach.signin.ui

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jaumelloretenriquez.coach.R
import com.jaumelloretenriquez.coach.signin.ui.composables.CircularButton
import com.jaumelloretenriquez.coach.signin.ui.composables.RoundedButton

@Composable
fun SignInScreen(signInViewModel: SignInViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 15.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), signInViewModel)
    }
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close,
        contentDescription = stringResource(id = R.string.close_app),
        modifier = modifier.clickable { activity.finish() })
}

@Composable
fun Body(modifier: Modifier, signInViewModel: SignInViewModel) {
    /*val email: String by signInViewModel.email.observeAsState(initial = "")
    val password: String by signInViewModel.password.observeAsState(initial = "")
    val isLoginEnable: Boolean by signInViewModel.isButtonLoginEnable.observeAsState(initial = false)*/

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        /*Phone(email) {
            loginViewModel.onLoginChanged(email = it, password = password)
        }*/
        Spacer(modifier = Modifier.size(4.dp))
        /*Password(password) {
            loginViewModel.onLoginChanged(email = email, password = it)
        }*/
        Spacer(modifier = Modifier.size(8.dp))
        //ForgotPassword(Modifier.align(Alignment.End))
        //Spacer(modifier = Modifier.size(16.dp))
        LoginButton(true, signInViewModel)
        Spacer(modifier = Modifier.size(16.dp))
        OauthButtons(signInViewModel = signInViewModel)
    }
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(id = R.string.app_name),
        modifier = modifier
            .size(170.dp)
            .clip(CircleShape)
    )
}

@Composable
fun LoginButton(loginEnable: Boolean, signInViewModel: SignInViewModel) {
    RoundedButton(text = stringResource(id = R.string.sign_in), onClick = {}, enabled = loginEnable)
}

@Composable
fun OauthButtons(signInViewModel: SignInViewModel) {
    Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxSize()) {
        CircularButton(icon = Icons.Default.Face, text = "Facebook", color = Color.Blue) {

        }
        CircularButton(icon = Icons.Default.Settings, text = "Google", color = Color.Red) {

        }
        CircularButton(icon = Icons.Default.Favorite, text = "Github", color = Color.Black) {

        }
    }
}