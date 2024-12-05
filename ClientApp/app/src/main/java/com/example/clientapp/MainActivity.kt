package com.example.clientapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clientapp.ui.theme.ClientAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClientAppTheme {
                Greeting(
                    onClick = { openMomentsActivity() }
                )
            }
        }
    }

    private fun openMomentsActivity() {
        val intent = Intent()
            .setClassName(
                "com.example.moments",
                "com.example.moments.MainActivity"
            )
        startActivity(intent)
    }
}

@Composable
fun Greeting(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(150.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onClick
        ) {
            Text(text = "Open Moments")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    ClientAppTheme {
        Greeting()
    }
}