package com.tonpackage.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = NarutoOrange,
    secondary = NarutoBlue,
    background = LightBackground
)

private val DarkColors = darkColorScheme(
    primary = NarutoOrange,
    secondary = NarutoBlue,
    background = DarkBackground
)

@Composable
fun NarutoUniverseTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = NarutoTypography,
        content = content
    )
}