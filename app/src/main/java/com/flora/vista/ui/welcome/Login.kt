package com.flora.vista.ui.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.flora.vista.component.RegisterTextClick
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
                    .verticalScroll(rememberScrollState())
            ) {
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