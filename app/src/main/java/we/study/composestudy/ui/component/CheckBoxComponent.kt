package we.study.composestudy.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun CheckBoxComponent() {
    Row(verticalAlignment = Alignment.CenterVertically) {
//        var checkStatus = false
//        var checkStatus = remember { mutableStateOf(false) }
        var checkStatus by remember { mutableStateOf(false) }
//        val (checked, setChecked) = remember { mutableStateOf(false) }
        Checkbox(
            checked = checkStatus,
            onCheckedChange = { checkStatus = it },
            modifier = Modifier.padding(4.dp),
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.White,
            )
        )
        Text(
            text = "안녕하세요",
            modifier = Modifier.clickable {
                checkStatus = !checkStatus
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxPreview() {
    ComposeStudyTheme {
        CheckBoxComponent()
    }
}

