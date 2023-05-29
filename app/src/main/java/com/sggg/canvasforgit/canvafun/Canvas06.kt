package com.sggg.canvasforgit.canvafun

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp


@Composable
fun FbIcon(){
    Box(modifier = mod2,
        contentAlignment = Alignment.Center) {
        // val assetManager = LocalContext.current.assets
        val paint = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize=200f
            color = Color.White.toArgb()
            //  typeface = android.graphics.Typeface.createFromAsset(assetManager,"FACEBOLF.OTF")
        }

        Canvas(modifier = Modifier
            .size(150.dp)
            .padding(16.dp)){
            drawRoundRect(
                color = Color.Blue,
                cornerRadius = CornerRadius(20f,20f),
            )
            drawContext.canvas.nativeCanvas.drawText("f", center.x+25, center.y+90, paint)
        }
    }
}