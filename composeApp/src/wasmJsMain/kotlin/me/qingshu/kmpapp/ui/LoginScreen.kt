package me.qingshu.kmpapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
private fun WebLoginLayout() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary.copy(alpha = 0.1f)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .widthIn(max = 1200.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Welcome to Our App",
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.primary,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Sign in to continue your journey",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.7f),
                )
            }

            Surface(
                modifier = Modifier
                    .width(400.dp)
                    .padding(end = 48.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp),
            ) {
                LoginView(
                    onLoginSuccess = {
                        window.alert("Success")
                    },
                    onNavigateToRegister = {},
                )
            }
        }
    }
}