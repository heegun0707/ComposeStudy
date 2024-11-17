package we.study.composestudy.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun SurfaceComponent() {
    Surface(
        modifier = Modifier.padding(5.dp),
        color = MaterialTheme.colorScheme.error,
        contentColor = Color.Black,
        shadowElevation = 5.dp,
        border = BorderStroke(width = 2.dp, Color.Magenta),
        shape = CircleShape
    ) {
        Text(
            text = "Hello Surface",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SurfacePreview() {
    ComposeStudyTheme {
        SurfaceComponent( )
    }
}