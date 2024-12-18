package com.example.mythirdcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mythirdcomposeapp.ui.theme.MyThirdComposeAppTheme

@Preview(showBackground = true)
@Composable
fun SimpleFilledTextFieldSample()
{
    var text by remember { mutableStateOf("Hello") }
    var text3 by rememberSaveable { mutableStateOf("Hello") }
    // NOVALE: var text2 = "Pepe"

    TextField(
        value = text3,
        onValueChange = {text3 = it},
        label = { Text("Label") }
    )
}

