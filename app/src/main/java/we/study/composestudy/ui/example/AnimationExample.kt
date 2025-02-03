package we.study.composestudy.ui.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun AnimationExample() {
    var helloWorldVisible by remember { mutableStateOf(true) }
    var isRed by remember { mutableStateOf(false) }

//    val background = Color.LightGray
    // 단계 4: `backgroundColor`를 `animateColorAsState`로
    // 변경하세요.
    // `targetValue`는 `isRed`에 따라 `Color`를 설정합니다.

    val backgroundColor by animateColorAsState(
        targetValue = if (isRed) Color.Red else Color.White
    )

    val alpha by animateFloatAsState(
        targetValue = if (isRed) 1.0f else 0.5f
    )

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(backgroundColor)
            .alpha(alpha)
    ) {
        AnimatedVisibility(
            visible = helloWorldVisible,
            enter = slideInHorizontally() + fadeIn(),
            exit = fadeOut()
        ) {
            Text(text = "Hello World")
        }

        // 단계 1: `Text`를 `AnimatedVisibility`로 감싸고 `visible`을
        // `helloWorldVisible`로 지정해봅시다.

        // 단계 2: `enter` 파라미터를 바꾸어봅시다.
        // 예:
        // `expandHorizontally()`
        // `scaleIn()`
        // `slideInHorizontally()`
        // `fadeIn()`

        // 단계 3: `enter` 값을 덧셈으로 결합해봅시다.
        // `exit`도 적절한 값을 설정해봅시다.
        Row(
            Modifier.selectable(
                selected = helloWorldVisible,
                onClick = { helloWorldVisible = true }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = helloWorldVisible,
                onClick = { helloWorldVisible = true }
            )
            Text(text = "Hello World 보이기")
        }

        Row(
            Modifier.selectable(
                selected = !helloWorldVisible,
                onClick = { helloWorldVisible = false }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !helloWorldVisible,
                onClick = { helloWorldVisible = false }
            )
            Text(text = "Hello World 감추기")
        }

        Text(text = "배경색 바꾸기")

        Row(
            Modifier.selectable(
                selected = !isRed,
                onClick = { isRed = false }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = !isRed,
                onClick = { isRed = false }
            )
            Text(text = "흰색")
        }

        Row(
            Modifier.selectable(
                selected = isRed,
                onClick = { isRed = true }
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isRed,
                onClick = { isRed = true }
            )
            Text(text = "빨간색")
        }
    }
}


@Composable
fun Animation2Example() {
    var isDarkMode by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState = isDarkMode, label = "Dark Mode Animation")

    val backgroundColor by transition.animateColor(
        transitionSpec = {
            tween(durationMillis = 2000)    // 애니메이션 전환에 걸리는 시간
        }
    ) { state ->
        when (state) {
            false -> Color.White
            true -> Color.Black
        }
    }

    val textColor by transition.animateColor { state ->
        when (state) {
            false -> Color.Black
            true -> Color.White
        }
    }

    val alpha by transition.animateFloat { state ->
        when (state) {
            false -> 0.7f
            true -> 1.0f
        }
    }

    Column (
        modifier = Modifier.padding(16.dp)
            .fillMaxWidth()
            .background(backgroundColor)
            .alpha(alpha)
    ) {
        RadioButtonWithText(text = "일반 모드", color = textColor, selected = !isDarkMode) {
            isDarkMode = false
        }

        RadioButtonWithText(text = "다크 모드", color = textColor, selected = isDarkMode) {
            isDarkMode = true
        }

        Crossfade(targetState = isDarkMode) { state ->
            when (state) {
                false -> {
                    Row {
                        Box (
                            Modifier.background(Color.Red)
                                .size(20.dp)
                        ) {
                            Text(text = "1")
                        }
                        Box (
                            Modifier.background(Color.Magenta)
                                .size(20.dp)
                        ) {
                            Text(text = "2")
                        }

                        Box (
                            Modifier.background(Color.Blue)
                                .size(20.dp)
                        ) {
                            Text(text = "3")
                        }
                    }
                }
                true -> {
                    Column {
                        Box (
                            Modifier.background(Color.Red)
                                .size(20.dp)
                        ) {
                            Text(text = "A")
                        }
                        Box (
                            Modifier.background(Color.Magenta)
                                .size(20.dp)
                        ) {
                            Text(text = "B")
                        }

                        Box (
                            Modifier.background(Color.Blue)
                                .size(20.dp)
                        ) {
                            Text(text = "C")
                        }
                    }

                }
            }

        }
    }
}

@Composable
fun RadioButtonWithText(
    text: String,
    color: Color = Color.Black,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row(
        Modifier.selectable(
            selected = selected,
            onClick = onClick
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(
            text = text,
            color = color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnimationPreview() {
    ComposeStudyTheme {
        Column {
            AnimationExample()
            Animation2Example()
        }
    }
}