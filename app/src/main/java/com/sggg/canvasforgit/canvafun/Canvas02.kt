package com.sggg.canvasforgit.canvafun

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke

import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random


@Composable
fun Canvas02(){
    Box(modifier = mod2,
        contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()){
            val orbitRadius = 100f

            for (ang in 0 until 359 step 10){
                val rad = Math.toRadians(ang.toDouble())
                val x = orbitRadius *cos(rad).toFloat() + Random.nextDouble(600.0).toFloat()
                val y = orbitRadius *sin(rad).toFloat() + Random.nextDouble(600.0).toFloat()
                val random = Random(System.currentTimeMillis())
                drawCircle(
                    color =  Color(
                        random.nextInt(256),
                        random.nextInt(256),
                        random.nextInt(256),
                    ),
                    style = Stroke(width = 1f),
                    radius = (10..150).random().toFloat(),
                    center = Offset( x, y )
                )
            }
        }
    }
}