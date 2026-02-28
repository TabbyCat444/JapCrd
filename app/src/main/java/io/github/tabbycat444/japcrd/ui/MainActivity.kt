package io.github.tabbycat444.japcrd.ui

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
 * MainActivity serves as the entry point of the application and is responsible for setting
 * up the UI using Jetpack Compose. It initializes a ViewModel for managing the state
 * of the application and applies the app's theme. The activity also enables edge-to-edge
 * system UI rendering.
 *
 * Primary responsibilities:
 * - Set up and apply the JapCrdTheme to define the visual styling of the application.
 * - Manage the lifecycle of the associated ViewModel (JapCrdViewModel).
 * - Inflate the FlashcardScreen composable to display the flashcard user interface.
 *
 * Functions:
 * - `onCreate`: Lifecycle callback invoked when the activity is created. It sets up the
 *    application's theme and initializes the main content of the UI.
 * - `GreetingPreview`: A composable preview function to render the FlashcardScreen for design
 *    time inspection in development environments.
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

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        JapCrdTheme {
            FlashcardScreen(viewModel = JapCrdViewModel())
        }
    }
}