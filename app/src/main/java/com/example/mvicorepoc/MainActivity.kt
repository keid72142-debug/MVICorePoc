package com.example.mvicorepoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.mvicorepoc.presentation.navigation.MVICorePocNavGraph
import com.example.mvicorepoc.presentation.theme.MVICorePocTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            MVICorePocTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    MVICorePocNavGraph(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                paddingValues = padding
                            ),
                        navController = navController,
                    )

                }
            }
        }
    }
}
