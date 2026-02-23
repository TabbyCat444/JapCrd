package io.github.tabbycat444.japcrd.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.tabbycat444.japcrd.viewmodel.JapCrdViewModel
import io.github.tabbycat444.japcrd.ui.theme.JapCrdTheme
import io.github.tabbycat444.japcrd.ui.components.TitleText
import io.github.tabbycat444.japcrd.ui.screens.FlashCard

class MainActivity : ComponentActivity() {

    private val viewModel: JapCrdViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JapCrdTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        FlashCard(
                            viewModel = JapCrdViewModel(),
                            modifier = Modifier.align(Alignment.Center)
                        )
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .fillMaxWidth()
                                .fillMaxHeight(0.25f),
                            contentAlignment = Alignment.Center
                        ) {
                            TitleText("Basic Hiragana")
                        }
                    }
                }
            }
        }
    }
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JapCrdTheme {
        FlashCard(viewModel = JapCrdViewModel())
    }
}
}