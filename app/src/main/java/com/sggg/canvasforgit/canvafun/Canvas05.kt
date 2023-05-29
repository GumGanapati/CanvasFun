package com.sggg.canvasforgit.canvafun

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun InstaIcon(){
    val instColor = listOf(Color.Yellow, Color.Red, Color.Magenta)
    Box(modifier = mod2,
        contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier
            .size(150.dp)
            .padding(16.dp)){
            drawRoundRect(
                brush = Brush.linearGradient(colors = instColor),
                cornerRadius = CornerRadius(60f,60f),
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )
            drawCircle(
                brush = Brush.linearGradient(colors = instColor),
                radius = 45f,
                style = Stroke(width = 15f, cap = StrokeCap.Round)
            )
            drawCircle(
                brush = Brush.linearGradient(colors = instColor),
                radius = 13f,
                center = Offset(this.size.width*0.80f, this.size.height*0.20f)
            )
        }
    }
}