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
fun Canvas03(){
    Box(modifier = mod2,
        contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()){
            val orbitRadius = 100f
            for (ang in 0 until 359*10 step 2){
                val rad = Math.toRadians(ang.toDouble())
                val x = (orbitRadius + ang/10) * cos(rad).toFloat()
                val y = (orbitRadius + ang/10) * sin(rad).toFloat()
                val random = Random(System.currentTimeMillis())
                drawCircle(
                    color =  Color(
                        (0..255).random(),
                        (0..255).random(),
                        (0..255).random(),
                    ),
                    style = Stroke(width = 1f),
                    radius = (1..10).random().toFloat(),
                    center = Offset( this.center.x + x,this.center.y + y )
                )
            }
        }
    }
}