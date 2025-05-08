package me.qingshu.kmpapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
expect fun LoginScreen()

@Composable
fun LoginView(
    onLoginSuccess: () -> Unit,
    onNavigateToRegister: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Welcome",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(24.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            isError = errorMessage != null,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            isError = errorMessage != null,
            modifier = Modifier.fillMaxWidth(),
        )

        errorMessage?.let {
            Text(
                text = it,
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val error = validateForm(username, password)
                if (error == null) {
                    isLoading = true
                    errorMessage = null
                    simulateLogin(username, password) { success ->
                        isLoading = false
                        if (success) {
                            onLoginSuccess()
                        } else {
                            errorMessage = "Wrong username or password"
                        }
                    }
                } else {
                    errorMessage = error
                }
            },
            enabled = !isLoading,
            modifier = Modifier.fillMaxWidth(),
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = Color.White)
            } else {
                Text("Sign")
            }
        }

        TextButton(onClick = onNavigateToRegister) {
            Text("Don't have an account? Sign up now", color = MaterialTheme.colors.primary)
        }
    }
}

private fun validateForm(username: String, password: String): String? {
    return when {
        username.isEmpty() -> "The username is empty"
        password.isEmpty() -> "The password is empty"
        password.length < 6 -> "The password must be at least 6 digits"
        else -> null
    }
}

@OptIn(DelicateCoroutinesApi::class)
private fun simulateLogin(
    username: String,
    password: String,
    callback: (Boolean) -> Unit,
) {
    GlobalScope.launch {
        delay(1500)
        callback(username == "admin" && password == "123456")
    }
}