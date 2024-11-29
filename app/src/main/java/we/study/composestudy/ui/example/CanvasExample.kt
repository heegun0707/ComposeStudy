package we.study.composestudy.ui.example

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.R
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun CanvasExample() {
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(Color.Red, Offset(300f, 100f), Offset(500f, 400f), 2f)
        drawCircle(Color.Yellow, 100f, Offset(150f, 400f))
        drawRect(Color.Magenta, Offset(300f, 300f), Size(100f, 100f))

        drawLine(Color.Green, Offset(20.01f, 210.0f), Offset(230.0f, 120.0f))
        drawLine(Color.Green, Offset(230.0f, 120.0f), Offset(20.01f, 30.0f))
        drawLine(Color.Green, Offset(20.01f, 30.0f), Offset(20.0f, 100.0f))
        drawLine(Color.Green, Offset(20.0f, 100.0f), Offset(170.0f, 120.0f))
        drawLine(Color.Green, Offset(170.0f, 120.0f), Offset(20.0f, 140.0f))
        drawLine(Color.Green, Offset(20.0f, 140.0f), Offset(20.01f, 210.0f))
    }
}

@Composable
fun DrawRectExample() {
    Canvas(modifier = Modifier.size(200.dp)) {
        drawRect(
            color = Color.Blue,
            topLeft = Offset(50f, 50f),
            size = Size(100f, 100f)
        )
    }
}

@Composable
fun DrawRoundRectExample() {
    Canvas(modifier = Modifier.size(200.dp)) {
        drawRoundRect(
            color = Color.Magenta,
            topLeft = Offset(50f, 50f),
            size = Size(100f, 100f),
            cornerRadius = CornerRadius(20f, 20f)
        )
    }
}

@Composable
fun DrawLineExample() {
    Canvas(modifier = Modifier.size(200.dp)) {
        drawLine(
            color = Color.Green,
            start = Offset(0f, 0f),
            end = Offset(200f, 200f),
            strokeWidth = 5f
        )
    }
}

@Composable
fun DrawPathExample() {
    Canvas(modifier = Modifier.size(200.dp)) {
        val path = Path().apply {
            moveTo(50f, 50f)
            lineTo(150f, 50f)
            lineTo(100f, 150f)
            close()
        }
        drawPath(
            path = path,
            color = Color.Yellow
        )
    }
}

@Composable
fun DrawCircleExample() {
    Canvas(modifier = Modifier.size(200.dp)) {
        drawCircle(
            color = Color.Red,
            radius = 50f,
            center = Offset(100f, 100f)
        )
    }
}

@Composable
fun DrawOvalExample() {
    Canvas(modifier = Modifier.size(200.dp)) {
        drawOval(
            color = Color.Cyan,
            topLeft = Offset(50f, 50f),
            size = Size(100f, 50f)
        )
    }
}

@Composable
fun DrawImageExample() {
    val image = ImageBitmap.imageResource(id = R.drawable.dog1) // 이미지 리소스
    Canvas(modifier = Modifier.size(200.dp)) {
        drawImage(
            image = image,
            topLeft = Offset(50f, 50f)
        )
    }
}

@Composable
fun DrawTextExample() {
    Canvas(modifier = Modifier.size(200.dp)) {
        drawContext.canvas.nativeCanvas.apply {
            drawText(
                "Hello, World!",
                50f,
                100f,
                Paint().apply {
                    color = android.graphics.Color.BLACK
                    textSize = 40f
                }
            )
        }
    }
}

@Composable
fun DrawArcExample() {
    Canvas(modifier = Modifier.size(300.dp)) {
        val sizeArc = drawContext.size / 1.5f

        drawArc(
            color = Color.Gray,
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = false,
            style = Stroke(width = 70f),
            topLeft = Offset(
                (size.width - sizeArc.width) / 2f,
                (size.height - sizeArc.height) / 2f
            ),
            size = sizeArc
        )

        drawArc(
            color = Color.Blue,
            startAngle = 90f,
            sweepAngle = 270f,
            useCenter = false,
            style = Stroke(
                width = 70f,
                cap = StrokeCap.Round
            ),
            topLeft = Offset(
                (size.width - sizeArc.width) / 2f,
                (size.height - sizeArc.height) / 2f
            ),
            size = sizeArc
        )
    }
}

@Composable
fun DrawGather() {
    DrawRectExample()
    DrawRoundRectExample()
    DrawLineExample()
    DrawPathExample()
    DrawCircleExample()
    DrawOvalExample()
    DrawArcExample()
    DrawTextExample()
    DrawImageExample()
}

@Preview(showBackground = true)
@Composable
fun CanvasPreview() {
    ComposeStudyTheme {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            DrawGather()
        }
//        Column {
//            CanvasExample()
//            DrawArcExample()
//        }
    }
}