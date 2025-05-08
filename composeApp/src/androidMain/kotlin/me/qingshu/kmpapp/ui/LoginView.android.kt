package me.qingshu.kmpapp.ui

import androidx.compose.runtime.Composable

@Composable
actual fun LoginScreen() {
    LoginView(
        onLoginSuccess = {},
        onNavigateToRegister = {}
    )
}