package com.jaumelloretenriquez.coach.signup.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.jaumelloretenriquez.coach.R
import com.jaumelloretenriquez.coach.ui.theme.BrownCoach
import com.jaumelloretenriquez.coach.ui.theme.YellowCoach

@Composable
fun BasicTextField(
    value: String,
    label: String,
    onTextChanged: (String) -> Unit,
    placeholder: String,
    imageVector: ImageVector,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            focusedContainerColor = YellowCoach,
            focusedLabelColor = BrownCoach,
            focusedPlaceholderColor = BrownCoach,
            focusedLeadingIconColor = BrownCoach,
            focusedSupportingTextColor = BrownCoach,
            focusedBorderColor = BrownCoach,
            unfocusedTextColor = Color.Black,
            unfocusedContainerColor = YellowCoach,
            unfocusedLabelColor = BrownCoach,
            unfocusedPlaceholderColor = BrownCoach,
            unfocusedLeadingIconColor = BrownCoach,
            unfocusedSupportingTextColor = BrownCoach,
            unfocusedBorderColor = BrownCoach,
        ),
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = label)
        }
    )
}

@Composable
fun PasswordTextField(password: String, imageVector: ImageVector, onTextChanged: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(stringResource(id = R.string.password)) },
        placeholder = { Text(stringResource(id = R.string.password)) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            focusedContainerColor = YellowCoach,
            focusedLabelColor = BrownCoach,
            focusedPlaceholderColor = BrownCoach,
            focusedLeadingIconColor = BrownCoach,
            focusedSupportingTextColor = BrownCoach,
            focusedBorderColor = BrownCoach,
            unfocusedTextColor = Color.Black,
            unfocusedContainerColor = YellowCoach,
            unfocusedLabelColor = BrownCoach,
            unfocusedPlaceholderColor = BrownCoach,
            unfocusedLeadingIconColor = BrownCoach,
            unfocusedSupportingTextColor = BrownCoach,
            unfocusedBorderColor = BrownCoach,
        ),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    imageVector = image,
                    contentDescription = stringResource(id = R.string.show_password),
                    tint = BrownCoach
                )
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        leadingIcon = { Icon(imageVector = imageVector, contentDescription = stringResource(id = R.string.password))}
    )
}