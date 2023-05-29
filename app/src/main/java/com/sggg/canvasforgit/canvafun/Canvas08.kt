package com.sggg.canvasforgit.canvafun

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun Rain(x: Float, y: Float){

    val infiniteTransition = rememberInfiniteTransition()
    val radius = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 200f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2000,
                delayMillis = ((100..7000).random()),
                easing = FastOutSlowInEasing
            )
        )
    )
    Box(
        modifier = Modifier.size(500.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = Color(
                    (0..255).random(),
                    (0..255).random(),
                    (0..255).random(),
                ),
                style = Stroke(width = if(radius.value<100) 1f
                else 2f),
                radius = radius.value,
                center = Offset(x , y )
            )
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SoRainy(){
    Box(
        modifier = mod2,
        contentAlignment = Alignment.Center
    ) {
        for (i in 1..15){
            val x= Random.nextDouble(600.0).toFloat()
            val  y= Random.nextDouble(600.0).toFloat()
            Rain(x = x, y = y)
        }
    }
}