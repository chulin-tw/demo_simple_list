package com.example.simplelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.simplelist.ui.theme.SimpleListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    List(
                         modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun List(modifier: Modifier = Modifier) {
    Column {
        ListItem("1.This is text1.")
        ListItem("2.This is text2.")
        ListItem("3.This is text3.")
    }
}

@Composable
fun ListItem(title:String,modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Column {
        Text(
            text = title
        )
        Image(
            painter = image,
            contentDescription = null,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TextPreview() {
    SimpleListTheme {
        List()
    }
}