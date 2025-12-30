package com.example.mvicorepoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.mvicorepoc.presentation.navigation.MVICorePocNavGraph
import com.example.mvicorepoc.presentation.theme.MVICorePocTheme
import dagger.hilt.android.AndroidEntryPoint

val LocalSnackbarHostState = compositionLocalOf<SnackbarHostState> {
    error("No SnackbarHostState provided. Make sure to provide it at the NavHost level.")
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val snackbarHostState = remember { SnackbarHostState() }

            MVICorePocTheme {
                CompositionLocalProvider(LocalSnackbarHostState provides snackbarHostState) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                        Box(modifier = Modifier.fillMaxSize()) {
                            MVICorePocNavGraph(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(
                                        paddingValues = padding
                                    ),
                                navController = navController,
                            )

                            SnackbarHost(
                                hostState = snackbarHostState,
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(padding)
                            )
                        }
                    }
                }
            }
        }
    }
}
