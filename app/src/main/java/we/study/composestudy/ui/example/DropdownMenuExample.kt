package we.study.composestudy.ui.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun DropdownMenuExample() {
    var isExpandDropdownMenu by remember { mutableStateOf(false) }
    var position by remember { mutableIntStateOf(-1) }

    val nameList = listOf("Alexander", "Isabella", "Benjamin", "Sophia", "Christopher")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { isExpandDropdownMenu = true }) {
                Text(text = "Open DropdownMenu")
            }
            Text(text = "SelectName: ${if (position == -1) "-" else nameList[position]}")

            DropdownMenu(
                expanded = isExpandDropdownMenu,
                onDismissRequest = { isExpandDropdownMenu = false }
            ) {
                nameList.forEachIndexed { index, name ->
                    DropdownMenuItem(onClick = {
                        isExpandDropdownMenu = false
                        position = index
                    }, text = { Text(name) })
                }
            }
        }
    }
}

@Composable
fun CustomDropdownMenu(
    expanded: Boolean,
    onDismiss: () -> Unit,
    onItemClick: () -> Unit,
    nameList: List<String>
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismiss
    ) {
        nameList.forEachIndexed { index, name ->
            DropdownMenuItem(onClick = onItemClick, text = { Text(name) })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropdownMenuPreview() {
    ComposeStudyTheme {
        DropdownMenuExample()
//        CustomDropdownMenu(true, {}, {}, {})
    }
}