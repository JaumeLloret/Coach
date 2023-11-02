package com.jaumelloretenriquez.coach.signin.ui

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.jaumelloretenriquez.coach.R
import com.jaumelloretenriquez.coach.signin.ui.composables.BasicTextField
import com.jaumelloretenriquez.coach.signin.ui.composables.CircularButton
import com.jaumelloretenriquez.coach.signin.ui.composables.PasswordTextField
import com.jaumelloretenriquez.coach.signin.ui.composables.RoundedButton
import com.jaumelloretenriquez.coach.ui.routes.Routes.*
import com.jaumelloretenriquez.coach.ui.theme.BrownCoach

@Composable
fun SignInScreen(navController: NavHostController, signInViewModel: SignInViewModel) {
    ConstraintLayout(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 15.dp)
            .fillMaxSize(),
    ) {
        val (header, body, footer) = createRefs()
        val topGuide = createGuidelineFromTop(0.38f)

        Header(modifier = Modifier.constrainAs(header) {
            top.linkTo(parent.top)
        })
        Body(modifier = Modifier.constrainAs(body) {
            top.linkTo(topGuide)
        }, signInViewModel = signInViewModel, navController)
        Footer(modifier = Modifier.constrainAs(footer) {
            bottom.linkTo(parent.bottom)
        }, navController)
    }
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Box(modifier.fillMaxWidth()) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(id = R.string.close_app),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clickable { activity.finish() },
            tint = BrownCoach
        )
        ImageLogo(Modifier.align(Alignment.TopCenter))
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
fun Body(modifier: Modifier, signInViewModel: SignInViewModel, navController: NavHostController) {
    val emailOrPhone: String = "" //by signInViewModel.email.observeAsState(initial = "")
    val password: String = "" //by signInViewModel.password.observeAsState(initial = "")
    val isLoginEnable: Boolean =
        true //by signInViewModel.isButtonLoginEnable.observeAsState(initial = false)

    Column(modifier = modifier.fillMaxWidth()) {
        PhoneOrEmailInputText(emailOrPhone) {
            //loginViewModel.onLoginChanged(email = it, password = password)
            Log.i("DAM", "PhoneOrEmail")
        }
        Spacer(modifier = Modifier.size(16.dp))
        PasswordInputText(password) {
            //loginViewModel.onLoginChanged(email = email, password = it)
            Log.i("DAM", "Password")
        }
        Spacer(modifier = Modifier.size(16.dp))
        //ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(isLoginEnable, signInViewModel, navController)
        Spacer(modifier = Modifier.size(32.dp))
        OauthButtons(signInViewModel = signInViewModel)
    }
}

@Composable
fun PhoneOrEmailInputText(value: String, onTextChanged: (String) -> Unit) {
    BasicTextField(
        value = value,
        placeholder = stringResource(id = R.string.user),
        label = stringResource(id = R.string.email_or_phone),
        onTextChanged = onTextChanged
    )
}

@Composable
fun PasswordInputText(password: String, onTextChanged: (String) -> Unit) {
    PasswordTextField(
        password = password,
        onTextChanged = onTextChanged
    )
}

@Composable
fun LoginButton(
    loginEnable: Boolean,
    signInViewModel: SignInViewModel,
    navController: NavHostController
) {
    RoundedButton(
        text = stringResource(id = R.string.login),
        onClick = { navController.navigate(HomeScreen.createRoute(3, "Cucala")) },
        enabled = loginEnable
    )
}

@Composable
fun OauthButtons(signInViewModel: SignInViewModel) {
    Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxSize()) {
        CircularButton(
            icon = painterResource(id = R.drawable.ic_facebook),
            text = "Facebook",
            color = Color.Blue
        ) {

        }
        CircularButton(
            icon = painterResource(id = R.drawable.ic_google),
            text = "Google",
            color = Color.Red
        ) {

        }
        CircularButton(
            icon = painterResource(id = R.drawable.ic_github),
            text = "Github",
            color = Color.Black
        ) {

        }
    }
}

@Composable
fun Footer(modifier: Modifier, navController: NavHostController) {
    Column(modifier = modifier.fillMaxWidth()) {
        SignUpButton(navController)
    }
}

@Composable
fun SignUpButton(navController: NavHostController) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(id = R.string.sign_up_question),
            fontSize = 16.sp,
            color = BrownCoach
        )
        Text(
            text = stringResource(id = R.string.sign_up),
            Modifier
                .padding(horizontal = 8.dp)
                .clickable { navController.navigate(SignUpScreen.route) },
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = BrownCoach,
        )
    }
}