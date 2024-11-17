package we.study.composestudy.ui.component

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun ModifierComponent() {
    var isClicked by remember { mutableStateOf(false) }

    val boxSize by animateDpAsState(if (isClicked) 200.dp else 300.dp, label = "")
    val boxColor by animateColorAsState(if (isClicked) Color.Red else Color.Green, label = "")

    Box(modifier = Modifier.size(boxSize)
        .background(boxColor)
        .border(5.dp, Color.Blue, RectangleShape)
        .padding(50.dp)
        .clickable {
            isClicked = !isClicked
            Log.d("Modifier", "Click Box")
        }
    ) {
        Text(
            text = "Hello Box",
            modifier = Modifier.align(Alignment.Center)
                .offset(x = 50.dp, y= 20.dp)
                .border(2.dp, Color.Blue, RectangleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierPreview() {
    ComposeStudyTheme {
        ModifierComponent( )
    }
}