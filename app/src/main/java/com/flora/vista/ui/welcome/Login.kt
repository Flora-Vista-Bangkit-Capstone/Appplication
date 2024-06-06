package com.flora.vista.ui.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.flora.vista.R
import com.flora.vista.component.EditTextField
import com.flora.vista.component.LoginButton
import com.flora.vista.component.LoginImage
import com.flora.vista.component.PasswordTextField
import com.flora.vista.component.RegisterTextClick
import com.flora.vista.component.WelcomeTitleText
import com.flora.vista.ui.theme.FloraVistaTheme

class Login {
}

@Composable
fun LoginUI(navController: NavController) {
    FloraVistaTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState()),verticalArrangement = Arrangement.Center
            ) {
                LoginImage()

                WelcomeTitleText(value = stringResource(id = R.string.title_activity_login))
                Spacer(modifier = Modifier.height(15.dp))

                EditTextField(labelValue = stringResource(id = R.string.email))
                Spacer(modifier = Modifier.height(8.dp))

                PasswordTextField(labelValue = stringResource(id = R.string.password))
                Spacer(modifier = Modifier.height(20.dp))

                LoginButton(value = stringResource(id = R.string.button_activity_login))
                Spacer(modifier = Modifier.height(10.dp))

                RegisterTextClick(
                    onRegisterClick = {
                        navController.navigate("signup")
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    LoginUI(navController = navController)
}