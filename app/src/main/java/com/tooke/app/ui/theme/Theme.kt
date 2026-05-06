package com.tooke.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val TookeGreen = Color(0xFF2D6A4F)
val TookeGreenLight = Color(0xFF52B788)
val TookeGreenDark = Color(0xFF1B4332)
val TookeYellow = Color(0xFFF4D03F)
val TookeEarth = Color(0xFF8B5E3C)
val TookeBackground = Color(0xFFF0F7F4)
val TookeSurface = Color(0xFFFFFFFF)
val TookeDarkBackground = Color(0xFF0D1F17)
val TookeDarkSurface = Color(0xFF1A2E22)

private val LightColorScheme = lightColorScheme(
    primary = TookeGreen,
    onPrimary = Color.White,
    primaryContainer = TookeGreenLight,
    onPrimaryContainer = TookeGreenDark,
    secondary = TookeEarth,
    onSecondary = Color.White,
    tertiary = TookeYellow,
    onTertiary = Color.Black,
    background = TookeBackground,
    onBackground = Color(0xFF1A1A1A),
    surface = TookeSurface,
    onSurface = Color(0xFF1A1A1A),
    surfaceVariant = Color(0xFFDCEDE5),
    onSurfaceVariant = Color(0xFF3A3A3A),
    error = Color(0xFFB00020),
    onError = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = TookeGreenLight,
    onPrimary = TookeGreenDark,
    primaryContainer = TookeGreen,
    onPrimaryContainer = Color.White,
    secondary = Color(0xFFD4A574),
    onSecondary = Color(0xFF3E1F00),
    tertiary = TookeYellow,
    onTertiary = Color.Black,
    background = TookeDarkBackground,
    onBackground = Color(0xFFE8F5EE),
    surface = TookeDarkSurface,
    onSurface = Color(0xFFE8F5EE),
    surfaceVariant = Color(0xFF1E3A2B),
    onSurfaceVariant = Color(0xFFB8D4C4),
    error = Color(0xFFCF6679),
    onError = Color(0xFF370011)
)

@Composable
fun TookeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}