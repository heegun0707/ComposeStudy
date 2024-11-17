package we.study.composestudy.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!\nHello $name!\nHello $name!",
        modifier = modifier.width(300.dp)
            .padding(top = 8.dp, bottom = 8.dp),
        color = Color.Red,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        lineHeight = 36.sp,
        letterSpacing = 2.sp,
        maxLines = Int.MAX_VALUE,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
        overflow = TextOverflow.Ellipsis,
    )
}