package com.sggg.canvasforgit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sggg.canvasforgit.canvafun.Canvas01
import com.sggg.canvasforgit.canvafun.Canvas02
import com.sggg.canvasforgit.canvafun.Canvas03
import com.sggg.canvasforgit.canvafun.Canvas04
import com.sggg.canvasforgit.canvafun.Cloud
import com.sggg.canvasforgit.canvafun.CubicBezier
import com.sggg.canvasforgit.canvafun.FbIcon
import com.sggg.canvasforgit.canvafun.InstaIcon
import com.sggg.canvasforgit.canvafun.QuadraticBezier
import com.sggg.canvasforgit.canvafun.Shoulders
import com.sggg.canvasforgit.canvafun.SoRainy
import com.sggg.canvasforgit.canvafun.Spiral2
import com.sggg.canvasforgit.canvafun.Vale
import com.sggg.canvasforgit.ui.theme.CanvasForGitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasForGitTheme {
              LazyColumn(modifier = Modifier.fillMaxSize() ){
                  item { Canvas01() }
                  item { Canvas02() }
                  item { Canvas03() }
                  item { Canvas04() }
                  item { InstaIcon() }
                  item { FbIcon() }
                  item { Cloud() }
                  item { SoRainy() }
                  item { Shoulders() }
                  item { CubicBezier() }
                  item { QuadraticBezier() }
                  item { Vale() }
                  item { Spiral2() }
              }

            }
        }
    }
}

