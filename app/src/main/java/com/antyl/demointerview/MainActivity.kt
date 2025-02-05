package com.antyl.demointerview

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.antyl.navigation.AppNavHost
import com.antyl.ui.theme.DemoInterviewTheme
import com.antyl.ui.theme.Purple40
import com.antyl.ui.theme.Purple80
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoInterviewTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Purple80)
                ) { innerPadding ->
                    AppNavHost(paddingValues = innerPadding)
                }
            }
        }
    }
}