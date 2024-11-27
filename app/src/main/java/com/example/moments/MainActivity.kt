package com.example.moments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.moments.ui.MomentsApp
import com.example.moments.ui.theme.MomentsScheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MomentsScheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MomentsApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


