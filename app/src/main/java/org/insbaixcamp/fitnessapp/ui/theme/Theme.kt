package org.insbaixcamp.fitnessapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = FitnessOrange,
    onPrimary = Color.White,
    primaryContainer = Color(0xFF3E2723),
    onPrimaryContainer = Color(0xFFFFCC80),
    secondary = FitnessLime,
    onSecondary = Color.Black,
    tertiary = FitnessBlue,
    background = FitnessDarkBackground,
    onBackground = FitnessTextLight,
    surface = FitnessSurfaceDark,
    onSurface = FitnessTextLight,
    surfaceVariant = FitnessCardDark,
    onSurfaceVariant = FitnessTextGray
)

private val LightColorScheme = lightColorScheme(
    primary = FitnessOrange,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFE0B2),
    onPrimaryContainer = Color(0xFFE65100),
    secondary = Color(0xFF00C853),
    onSecondary = Color.White,
    tertiary = Color(0xFF0288D1),
    background = Color(0xFFF8F9FA),
    onBackground = Color(0xFF212121),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF212121),
    surfaceVariant = Color(0xFFEEEEEE),
    onSurfaceVariant = Color(0xFF757575)
)

@Composable
fun FitnessAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is false by default to enforce our custom energetic gym branding
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
