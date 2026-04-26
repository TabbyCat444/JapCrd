package io.github.tabbycat444.japcrd.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.tabbycat444.japcrd.ui.screens.FlashcardScreen
import io.github.tabbycat444.japcrd.ui.theme.JapCrdTheme
import io.github.tabbycat444.japcrd.viewmodel.JapCrdViewModel

/**
 * Main activity for the application, serving as the entry point.
 *
 * This activity sets up an edge-to-edge user interface and applies the application's theme.
 * It hosts a composable function that displays the flashcard screen, which is managed by
 * the application's ViewModel. The flashcard screen allows users to interact with Japanese
 * flashcards loaded from the associated ViewModel.
 */
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
                    FlashcardScreen(viewModel = viewModel)
                }
            }
        }
    }

    @SuppressLint("ViewModelConstructorInComposable")
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        JapCrdTheme {
            FlashcardScreen(viewModel = JapCrdViewModel())
        }
    }
}