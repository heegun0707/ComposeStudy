package we.study.composestudy.ui.example

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun AdvancedConstraintLayoutExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redBox, magentaBox, greenBox, text) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    top.linkTo(parent.top, margin = 18.dp)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    top.linkTo(parent.top, margin = 32.dp)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
                    top.linkTo(parent.top, margin = 64.dp)
                }
        )

        // 세 개 박스에 Chain을 걸고 싶다. (간격이 균등하게)
        createHorizontalChain(redBox, magentaBox, greenBox, chainStyle = ChainStyle.SpreadInside)
        // 세 개 박스의 제일 아래를 영역을 알고 싶다.
        val barrier = createBottomBarrier(redBox, magentaBox, greenBox)

        Text(
            text = "Hello ~ It's me Hello ~ It's me Hello ~ It's me Hello ~ It's me",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(barrier)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AdvancedConstraintLayoutPreview() {
    ComposeStudyTheme {
        AdvancedConstraintLayoutExample()
    }
}