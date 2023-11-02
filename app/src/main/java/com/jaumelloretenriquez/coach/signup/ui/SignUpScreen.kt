package com.jaumelloretenriquez.coach.signup.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.jaumelloretenriquez.coach.R
import com.jaumelloretenriquez.coach.signup.ui.composables.PasswordTextField
import com.jaumelloretenriquez.coach.signup.ui.composables.RoundedButton
import com.jaumelloretenriquez.coach.signup.ui.composables.BasicTextField
import com.jaumelloretenriquez.coach.ui.routes.Routes
import com.jaumelloretenriquez.coach.ui.routes.Routes.*
import com.jaumelloretenriquez.coach.ui.theme.BackgroundAreaReverse
import com.jaumelloretenriquez.coach.ui.theme.BrownCoach
import com.jaumelloretenriquez.coach.ui.theme.TitleTextStyle

@Composable
fun SignUpScreen(navController: NavHostController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 15.dp)
    ) {
        val (header, body, footer) = createRefs()

        Header(modifier = Modifier.constrainAs(header) {
            top.linkTo(parent.top)
            bottom.linkTo(body.top)
        })
        Body(modifier = Modifier.constrainAs(body) {
            top.linkTo(header.bottom)
            bottom.linkTo(footer.top)
        })
        Footer(modifier = Modifier.constrainAs(footer) {
            top.linkTo(body.bottom)
            bottom.linkTo(parent.bottom)
        }, navController)

        createVerticalChain(header, body, footer, chainStyle = ChainStyle.SpreadInside)
    }
}

@Composable
fun Header(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ImageLogo()
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = R.string.motivational_phrase), style = TitleTextStyle)
    }
}

@Composable
fun ImageLogo() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(id = R.string.app_name),
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
    )
}

@Composable
fun Body(modifier: Modifier) {
    val emailOrPhone: String = ""
    val user: String = ""
    val fullName: String = ""
    val password: String = ""
    val isLoginEnable: Boolean = true

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        PhoneOrEmailTextField(emailOrPhone) { }
        UserTextField(user) { }
        FullNameTextField(fullName) { }
        KeyWordTextField(password) { }
        Spacer(modifier = Modifier.height(4.dp))
        SignUpButton(isLoginEnable)
    }
}

@Composable
fun PhoneOrEmailTextField(value: String, onTextChanged: (String) -> Unit) {
    BasicTextField(
        value = value,
        placeholder = stringResource(id = R.string.user),
        label = stringResource(id = R.string.email_or_phone),
        onTextChanged = onTextChanged,
        imageVector = Icons.Filled.PhoneAndroid
    )
}

@Composable
fun UserTextField(value: String, onTextChanged: (String) -> Unit) {
    BasicTextField(
        value = value,
        placeholder = stringResource(id = R.string.username),
        label = stringResource(id = R.string.username),
        onTextChanged = onTextChanged,
        imageVector = Icons.Filled.AccountCircle
    )
}

@Composable
fun FullNameTextField(value: String, onTextChanged: (String) -> Unit) {
    BasicTextField(
        value = value,
        placeholder = stringResource(id = R.string.full_name),
        label = stringResource(id = R.string.name_and_surname),
        onTextChanged = onTextChanged,
        imageVector = Icons.Filled.Face
    )
}

@Composable
fun KeyWordTextField(password: String, onTextChanged: (String) -> Unit) {
    PasswordTextField(
        password = password,
        imageVector = Icons.Filled.Password,
        onTextChanged = onTextChanged
    )
}

@Composable
fun SignUpButton(loginEnable: Boolean /*signInViewModel: SignInViewModel*/) {
    RoundedButton(
        text = stringResource(id = R.string.register),
        onClick = {},
        enabled = loginEnable
    )
}

@Composable
fun Footer(modifier: Modifier, navController: NavHostController) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SignInButton(navController)
    }
}

@Composable
fun SignInButton(navController: NavHostController) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(id = R.string.sign_in_question),
            fontSize = 16.sp,
            color = BrownCoach
        )
        Text(
            text = stringResource(id = R.string.sign_in),
            Modifier
                .padding(horizontal = 8.dp)
                .clickable { navController.navigate(SignInScreen.route) },
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = BrownCoach,
        )
    }
}