package com.vincicent.translator_kmm.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vincicent.translator_kmm.android.core.theme.darkColors
import com.vincicent.translator_kmm.android.core.theme.lightColors

@Composable
fun TranslatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors
    } else {
        lightColors
    }
    val SfProText = FontFamily(
        Font(
            resId = R.font.sf_pro_text_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resId = R.font.sf_pro_text_medium,
            weight = FontWeight.Medium
        ),
        Font(
            resId = R.font.sf_pro_text_bold,
            weight = FontWeight.Bold
        ),
    )
    val typography = Typography(
        displayLarge = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        ),
        displayMedium = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        displaySmall = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = SfProText,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        ),
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
