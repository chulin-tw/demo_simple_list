package com.example.simplelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.simplelist.ui.theme.SimpleListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingText(
                        message = "Android", modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = message,
            fontSize = 40.sp,
            lineHeight = 116.sp
        )
        Text(
            text = "2.This is a Text.",
            fontSize = 40.sp,
            lineHeight = 116.sp
        )
        Text(
            text = "3.This is a Text.",
            fontSize = 40.sp,
            lineHeight = 116.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TextPreview() {
    SimpleListTheme {
        GreetingText("1.This is a Text.")

    }
}