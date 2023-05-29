package com.sggg.canvasforgit.canvafun

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

@Composable
fun Spiral(){
    val infiniteTransition = rememberInfiniteTransition()
    val delta by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue =  3f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 8000,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(modifier = Modifier.fillMaxSize()){
        val orbitRadius = 100f
        for (ang in 0 until 500 step 4){
            val rad = Math.toRadians(ang.toDouble())
            val x = (orbitRadius + ang) * cos(rad).toFloat() +(1..50).random()
            val y = (orbitRadius + ang) * sin(rad).toFloat() +(1..50).random()
            val random = Random(System.currentTimeMillis())
            drawCircle(
                color =  Color(
                    (0..255).random(),
                    (0..255).random(),
                    (0..255).random(),
                ),
                style = Fill,
                radius = (4..10).random()*delta,
                center = Offset( this.center.x + x,this.center.y + y )
            )
        }
    }
}

@Composable
fun Spiral2(){
    Box(modifier = mod2, contentAlignment = Alignment.Center) {
        val infiniteTransition = rememberInfiniteTransition()
        val ang2 by infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue =  -8000f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 78000,
                    easing = LinearEasing,
                ),
                repeatMode = RepeatMode.Restart
            )
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .rotate(ang2)) {
            Spiral()
            Box(modifier = Modifier
                .fillMaxSize().rotate(120f)) {
                Spiral() }
            Box(modifier = Modifier
                .fillMaxSize().rotate(240f)) {
                Spiral()
            }
        }
    }
}