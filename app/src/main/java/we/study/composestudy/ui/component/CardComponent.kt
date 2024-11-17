package we.study.composestudy.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.R
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun CardComponent() {
    Card (
        modifier = Modifier.padding(4.dp),
        colors = CardColors(
            containerColor = Color.DarkGray,
            contentColor = Color.Green,
            disabledContainerColor = Color.Black,
            disabledContentColor = Color.Blue
        )
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Column {
                Text(text = "조희근")
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = "하이 모두들 안녕 내가 누군지 아니~ 조희금다~ 조희금다~")
            }
        }
    }
}

data class CardData (
    val imageUri: String,
    val imageDescription: String,
    val author: String,
    val description: String
)

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ComposeStudyTheme {
        CardComponent()
    }
}

