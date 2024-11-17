package we.study.composestudy.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun RowComponent() {
    Row(
        modifier = Modifier
            .size(300.dp, 100.dp)
            .padding(5.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = "Hello",
            modifier = Modifier.weight(3f)
        )
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "추가"
        )
        Text(
            text = "Compose",
            modifier = Modifier.weight(2f)
        )
        Text(
            text = "Row",
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    ComposeStudyTheme {
        RowComponent()
    }
}