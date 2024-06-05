package com.flora.vista.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.flora.vista.ui.theme.FloraVistaTheme

class Home {
}

@Composable
fun HomeUI(){
    FloraVistaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
        }
    }
}

@Preview
@Composable
fun HomePreview(){
    HomeUI()
}