package com.sggg.canvasforgit.canvafun

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

@Composable
fun Cloud() {
    Box(
        modifier = mod2,
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            Modifier
                .size(200.dp)
                .padding(16.dp)
        ){
            val width = size.width
            val height = size.height
            val path = Path().apply {
                moveTo(width.times(.76f), height.times(.72f))
                cubicTo(
                    width.times(.93f),
                    height.times(.72f),
                    width.times(.98f),
                    height.times(.41f),
                    width.times(.76f),
                    height.times(.40f),
                )
                cubicTo(
                    width.times(.75f),
                    height.times(.21f),
                    width.times(.35f),
                    height.times(.21f),
                    width.times(.38f),
                    height.times(.50f),
                )
                cubicTo(
                    width.times(.25f),
                    height.times(.50f),
                    width.times(.20f),
                    height.times(.69f),
                    width.times(.41f),
                    height.times(.72f),
                )
                close()

                drawCircle(
                    color = Color.Yellow,
                    radius = width.times(.17f),
                    center = Offset(width.times(.35f),height.times(.35f))
                )

                val electricpath = Path().let {
                    it.moveTo(width*.30f, height*1.1f)
                    it.lineTo(width*.5f, height*.8f)
                    it.lineTo(width*.56f, height*.86f)
                    it.lineTo(width*.74f, height*.7f)
                    it.lineTo(width*.58f, height*.95f)
                    it.lineTo(width*.5f, height*.9f)
                    it.close()
                    it
                }
                drawPath(path = electricpath, color = Color.Yellow.copy(.8f))
            }
            drawPath(path =path, color = Color.White.copy(.9f))
        }
    }
}
