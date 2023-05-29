package com.sggg.canvasforgit.canvafun

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

import java.lang.Math.sin

val mod2 = Modifier
    .size(500.dp)
    .background(Color.Black)
    .padding(vertical = 8.dp)

@Composable
fun Canvas01() {
    Box(modifier = mod2,
        contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()){
            val orbitRadius = 200f
            drawCircle(
                color = Color.Yellow,
                style = Stroke(width = 10f),
                radius = orbitRadius,
                center = this.center
            )
            for (ang in 0 until 359 step 5){
                val rad = Math.toRadians(ang.toDouble())
                val x = orbitRadius * kotlin.math.cos(rad).toFloat()
                val y = orbitRadius * kotlin.math.sin(rad).toFloat()
                drawCircle(
                    color = Color.Blue,
                    style = Stroke(width = 1f),
                    radius = 140f,
                    center = Offset(this.center.x + x,this.center.y + y )
                )
            }
        }
    }
}