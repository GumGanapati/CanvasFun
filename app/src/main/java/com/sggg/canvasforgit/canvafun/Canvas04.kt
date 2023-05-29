package com.sggg.canvasforgit.canvafun

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Canvas04(){
    Box(modifier = mod2,
        contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()){
            val orbitRadius = 100f
            for (ang in 0 until 359*10 step 5){
                val rad = Math.toRadians(ang.toDouble())
                val x = (orbitRadius + ang/15) * cos(rad).toFloat()
                val y = (orbitRadius + ang/10) * sin(rad).toFloat()

                drawCircle(
                    color =  Color(
                        (0..255).random(),
                        (0..255).random(),
                        (0..255).random(),
                    ),
                    style = Fill,
                    radius = (1..10).random().toFloat(),
                    center = Offset( this.center.x + x,this.center.y + y )
                )
            }
        }
    }
}