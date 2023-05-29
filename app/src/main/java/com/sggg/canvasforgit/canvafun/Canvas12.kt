package com.sggg.canvasforgit.canvafun

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun Vale() {

    val offsetX0 = remember { mutableStateOf(0f) }
    val offsetY0 = remember { mutableStateOf(300f) }
    val offsetX1 = remember { mutableStateOf(325f) }
    val offsetY1 = remember { mutableStateOf(0f) }
    val offsetX2 = remember { mutableStateOf(575f) }
    val offsetY2 = remember { mutableStateOf(650f) }
    val offsetX3 = remember { mutableStateOf(850f) }
    val offsetY3 = remember { mutableStateOf(300f) }

    val infiniteTransition = rememberInfiniteTransition()
    val deltaY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue =  600f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1500,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(modifier = mod2,
        contentAlignment = Alignment.Center
    ) {

        Canvas(modifier = Modifier
            .size(300.dp)
            .clip(CircleShape)
            .background(Color.DarkGray)
        ) {

            for (i in 0..15){
                val delta = i*40
                val cubic = Path().apply {
                    moveTo(offsetX0.value, offsetY0.value+delta)
                    cubicTo(
                        offsetX1.value,
                        offsetY1.value+deltaY+delta,
                        offsetX2.value,
                        offsetY2.value-deltaY-delta/5,
                        offsetX3.value,
                        offsetY3.value+delta,
                    )
                }
                drawPath(path =cubic,
                    color = Color.Green,
                    style = Stroke(width = 2f) )
            }
        }
    }
}