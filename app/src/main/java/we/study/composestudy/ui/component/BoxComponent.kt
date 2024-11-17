package we.study.composestudy.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun BoxComponent() {
    Box(
        modifier = Modifier
            .size(200.dp, 100.dp)
            .padding(5.dp)
    ) {
        Text(
            text = "Hello",
            modifier = Modifier.align(Alignment.TopStart)
        )
        Text(
            text = "Compose",
            modifier = Modifier.align(Alignment.Center)
        )
        Text(
            text = "Box",
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    ComposeStudyTheme {
        BoxComponent()
    }
}