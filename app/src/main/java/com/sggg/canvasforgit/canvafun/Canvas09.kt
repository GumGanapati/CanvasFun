package com.sggg.canvasforgit.canvafun

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp


@Composable
fun Shoulders(){

    val offsetX1 = remember{ mutableStateOf(100f) }
    val offsetY1 = remember{ mutableStateOf(80f) }
    val offsetX2 = remember{ mutableStateOf(300f) }
    val offsetY2 = remember{ mutableStateOf(160f) }

    Box(modifier = mod2){
        Canvas(modifier = Modifier.fillMaxSize()) {
            var line = Path().let {
                it.moveTo(offsetX1.value+30, offsetY1.value+90)
                it.lineTo(offsetX2.value+30, offsetY2.value+90)
                it.close()
                it
            }
            drawPath(path = line,
                color = Color.White,
                style = Stroke(width = 2f)
            )
        }
        DragBox(x = offsetX1, y = offsetY1, color = Color.Yellow)
        DragBox(x = offsetX2, y = offsetY2, color = Color.Green )
    }
}


@Composable
fun DragBox(x: MutableState<Float>, y: MutableState<Float>, color: Color){
    val d = LocalDensity.current
    Column(modifier = Modifier
        .offset(
            (x.value / d.density).dp,
            (y.value / d.density).dp
        )
        .pointerInput(Unit) {
            detectDragGestures { change, dragAmount ->
                change.consume()
                x.value += dragAmount.x
                y.value += dragAmount.y
            }
        },
        verticalArrangement = Arrangement.Center) {
        Text(text = "${x.value.toInt()} / ${y.value.toInt()}",
            color = Color.White)
        Box(modifier = Modifier
            .size(20.dp)
            .background(color)
        )

    }

}