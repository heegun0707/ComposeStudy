package we.study.composestudy.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun SlotAPIComponent() {
    Column {
        MyCard(title = "Hello Card") {
            Text("This is the content of the card.")
            Button(onClick = { /* Do something */ }) {
                Text("Click Me")
            }
        }

        MyCard(title = "Hello Second Card") {
            Text("This is the content of the card.")
            Button(onClick = { /* Do something */ }) {
                Text("Click Me")
            }
        }
    }
}

@Composable
fun MyCard(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card {
        Column {
            Text(text = title)
            content() // 여기서 content 슬롯을 호출하여 다른 컴포저블을 삽입
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SlotAPIPreview() {
    ComposeStudyTheme {
        SlotAPIComponent()
    }
}

