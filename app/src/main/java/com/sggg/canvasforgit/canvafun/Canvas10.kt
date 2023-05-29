package com.sggg.canvasforgit.canvafun

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun CubicBezier() {
    val offsetX0 = remember { mutableStateOf(150f) }
    val offsetY0 = remember { mutableStateOf(650f) }
    val offsetX1 = remember { mutableStateOf(50f) }
    val offsetY1 = remember { mutableStateOf(50f) }
    val offsetX2 = remember { mutableStateOf(500f) }
    val offsetY2 = remember { mutableStateOf(50f) }
    val offsetX3 = remember { mutableStateOf(400f) }
    val offsetY3 = remember { mutableStateOf(650f) }
    val deltaX = 20
    val deltaY = 90  // this value may be different on the dif device
    Box(modifier = mod2) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val cubic = Path().apply {
                moveTo(offsetX0.value+deltaX, offsetY0.value+deltaY)
                cubicTo(
                    offsetX1.value+deltaX,
                    offsetY1.value+deltaY,
                    offsetX2.value+deltaX,
                    offsetY2.value+deltaY,
                    offsetX3.value+deltaX,
                    offsetY3.value+deltaY,
                )
            }

            val line1 = Path().let {
                it.moveTo(offsetX0.value+deltaX, offsetY0.value+deltaY)
                it.lineTo(offsetX1.value+deltaX, offsetY1.value+deltaY)
                it.close()
                it
            }
            val line2 = Path().let {
                it.moveTo(offsetX1.value+deltaX, offsetY1.value+deltaY)
                it.lineTo(offsetX2.value+deltaX, offsetY2.value+deltaY)
                it.close()
                it
            }
            val line3 = Path().let {
                it.moveTo(offsetX2.value+deltaX, offsetY2.value+deltaY)
                it.lineTo(offsetX3.value+deltaX, offsetY3.value+deltaY)
                it.close()
                it
            }

            drawPath(path = line1,
                color = Color.White,
                style = Stroke(width = 2f)
            )
            drawPath(path = line2,
                color = Color.White,
                style = Stroke(width = 2f)
            )
            drawPath(path = line3,
                color = Color.White,
                style = Stroke(width = 2f)
            )
            drawPath(path =cubic,
                color = Color.Green,
                style = Stroke(width = 3f) )
        }

        DragBox(x = offsetX0, y = offsetY0, color = Color.Yellow)
        DragBox(x = offsetX1, y = offsetY1, color = Color.Green )
        DragBox(x = offsetX2, y = offsetY2, color = Color.Green)
        DragBox(x = offsetX3, y = offsetY3, color = Color.Yellow)
    }
}
