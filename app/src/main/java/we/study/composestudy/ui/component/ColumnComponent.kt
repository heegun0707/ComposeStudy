package we.study.composestudy.ui.component

import androidx.compose.foundation.layout.Column
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
fun ColumnComponent() {
    Column(
        modifier = Modifier
            .size(100.dp, 200.dp)
            .padding(5.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Hello",
            modifier = Modifier.weight(3f)
        )
        Text(
            text = "Compose",
            modifier = Modifier.weight(2f)
        )
        Text(
            text = "Column",
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    ComposeStudyTheme {
        ColumnComponent()
    }
}