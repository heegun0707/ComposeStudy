package we.study.composestudy.ui.example

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import we.study.composestudy.ui.theme.ComposeStudyTheme
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun VisibilityAnimationExample() {
    var isVisible by remember { mutableStateOf(true) }

    val animatedFloat by animateFloatAsState(
        targetValue = if (isVisible) 1.0f else 0.0f,
        label = "Float Animation"
    )

    Column(
        modifier = Modifier.wrapContentSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(),
            exit = slideOutVertically()
        ) {
            Box(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .size(150.dp)
                    .background(Color.Green)
            )
        }
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Blue)
                .clickable { isVisible = isVisible.not() }
        )
    }
}

@Composable
fun VisibilityAnimationExample2() {
    var isVisible by remember { mutableStateOf(true) }

    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1.0f else 0f,
        label = "Float Animation"
    )

    Column(
        modifier = Modifier.wrapContentSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .size(150.dp)
                .alpha(alpha)
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Blue)
                .clickable { isVisible = isVisible.not() }
        )
    }
}

@Composable
fun BackgroundColorAnimationExample() {
    var isAnimated by remember { mutableStateOf(false) }
    val animatedColor by animateColorAsState(
        targetValue = if (isAnimated) Color.Green else Color.Blue,
        animationSpec = tween(durationMillis = 2000),
        label = "Background Color Animation",
        finishedListener = {
            Log.d("Animation", "Finish Color Change, Current Color is $it")
        }
    )

    Box (
        Modifier.padding(16.dp)
            .size(400.dp)
            .background(animatedColor)
            .clickable { isAnimated = isAnimated.not() }
    )
}

@Composable
fun SizeAnimationExample() {
    var isExpanded by remember { mutableStateOf(false) }
    val height by animateDpAsState(
        targetValue = if (isExpanded) 400.dp else 200.dp,
        animationSpec = tween(durationMillis = 2000)
    )

    Column (
        Modifier.padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box (
            Modifier.background(Color.Green)
                .fillMaxWidth()
                .height(if (isExpanded) 400.dp else 200.dp)
                .animateContentSize()   // 해당 위치 중요
                .clickable { isExpanded = isExpanded.not() }
        )

        Box (
            Modifier.background(Color.Green)
                .fillMaxWidth()
                .height(height)
                .clickable { isExpanded = isExpanded.not() }
        )
    }
}

@Composable
fun MovingBoxAnimationExample() {
    var boxOffset by remember { mutableStateOf(IntOffset(0, 0)) }
    val animatedOffset by animateIntOffsetAsState(
        targetValue = boxOffset,
        label = "animatedOffset"
    )
    val density = LocalDensity.current

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .offset { animatedOffset }
                .size(100.dp)
                .background(Color.Blue)
        )

        Button(
            onClick = {
                // 새로운 랜덤 위치 생성
                val maxWidth = (with(density) { 200.dp.toPx() }).roundToInt()
                val maxHeight = (with(density) { 200.dp.toPx() }).roundToInt()

                boxOffset = IntOffset(
                    Random.nextInt(0, maxWidth),
                    Random.nextInt(0, maxHeight)
                )
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text("Move Box")
        }
    }
}

@Composable
fun TextAnimationExample() {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 8f,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
        label = "scale"
    )
    val rotationValue by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )
    val animatedColor by infiniteTransition.animateColor(
        initialValue = Color.Green,
        targetValue = Color.Blue,
        animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
        label = "color"
    )
    Box(modifier = Modifier.fillMaxSize()) {
        BasicText(
            text = "Hello",
            color = { animatedColor },
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    rotationZ = rotationValue
                    transformOrigin = TransformOrigin.Center
                }
                .align(Alignment.Center),
            style = LocalTextStyle.current.copy(textMotion = TextMotion.Animated)
        )
    }
}

@Preview(showBackground = false)
@Composable
fun SimpleAnimationPreview() {
    ComposeStudyTheme {
        Column {
            Row {
                VisibilityAnimationExample()
                VisibilityAnimationExample2()
            }
            BackgroundColorAnimationExample()
            SizeAnimationExample()
        }
    }
}

@Preview(showBackground = false)
@Composable
fun SizeAnimationPreview() {
    ComposeStudyTheme {
        SizeAnimationExample()
    }
}

@Preview(showBackground = true)
@Composable
fun MovingBoxAnimationPreview() {
    ComposeStudyTheme {
        MovingBoxAnimationExample()
    }
}

@Preview(showBackground = true)
@Composable
fun TextScaleAnimationPreview() {
    ComposeStudyTheme {
        TextAnimationExample()
    }
}