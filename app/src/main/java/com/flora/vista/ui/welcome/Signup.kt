package com.flora.vista.ui.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.flora.vista.R
import com.flora.vista.component.BungaImage
import com.flora.vista.component.DescriptionText
import com.flora.vista.component.EditTextField
import com.flora.vista.component.PasswordTextField
import com.flora.vista.component.SubmitButton
import com.flora.vista.component.TextFieldTitle
import com.flora.vista.component.TitleText
import com.flora.vista.ui.theme.FloraVistaTheme

class Register {
}

@Composable
fun SignupUI(navController: NavController) {
    FloraVistaTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {
                BungaImage()
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
                    .padding(25.dp)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                TitleText(value = stringResource(id = R.string.title_activity_signup))
                DescriptionText(value = stringResource(id = R.string.signup_description))
                Spacer(modifier = Modifier.height(40.dp))

                TextFieldTitle(value = stringResource(id = R.string.name))
                EditTextField(labelValue = stringResource(id = R.string.name))
                Spacer(modifier = Modifier.height(20.dp))

                TextFieldTitle(value = stringResource(id = R.string.email))
                EditTextField(labelValue = stringResource(id = R.string.email))
                Spacer(modifier = Modifier.height(20.dp))

                TextFieldTitle(value = stringResource(id = R.string.password))
                PasswordTextField(labelValue = stringResource(id = R.string.password))
                Spacer(modifier = Modifier.height(20.dp))

                Spacer(modifier = Modifier.height(50.dp))
                SubmitButton(value = stringResource(id = R.string.title_activity_signup))
            }
        }
    }
}

@Preview
@Composable
fun SignupPreview() {
    val navController = rememberNavController()
    SignupUI(navController = navController)
}