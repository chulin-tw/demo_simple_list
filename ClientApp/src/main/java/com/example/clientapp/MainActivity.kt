package com.example.clientapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clientapp.ui.theme.ClientAppTheme
import com.example.moments.MainActivityKT
import com.example.momentsjava.MainActivityJava

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClientAppTheme {
                OpenMoments(
                    onKotlinClick = { openMomentsKotlinActivity() },
                    onJavaClick = { openMomentsJavaActivity() }
                )
            }
        }
    }

    private fun openMomentsKotlinActivity() {
        val intent = Intent(this, MainActivityKT::class.java)

        startActivity(intent)
    }

    private fun openMomentsJavaActivity() {
        val intent = Intent(this, MainActivityJava::class.java)
        startActivity(intent)
    }
}

@Composable
fun OpenMoments(
    onKotlinClick: () -> Unit = {},
    onJavaClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(150.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = onKotlinClick
        ) {
            Text(text = "Open Moments Kotlin")
        }
        Button(
            onClick = onJavaClick
        ) {
            Text(text = "Open Moments Java")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    ClientAppTheme {
        OpenMoments()
    }
}