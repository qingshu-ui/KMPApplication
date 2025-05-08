package me.qingshu.kmpapp.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val AppColors = lightColors(
    primary = Color(0xff2196f3),
    secondary = Color(0xff4caf50),
    error = Color(0xffd32f2f),
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = AppColors,
        typography = MaterialTheme.typography,
        content = content,
    )
}