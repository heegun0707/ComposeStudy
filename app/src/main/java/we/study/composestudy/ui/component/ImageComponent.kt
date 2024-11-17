package we.study.composestudy.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.R
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun ImageComponent() {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Android",
            contentScale = ContentScale.Inside,
            modifier = Modifier.size(100.dp, 80.dp),
            alpha = 0.5f,
            colorFilter = ColorFilter.tint(Color.Red)
        )
        Image(
            imageVector = Icons.Filled.Done,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    ComposeStudyTheme {
        ImageComponent()
    }
}