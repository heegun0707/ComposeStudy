package we.study.composestudy.ui.example

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun AlertDialogExample() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableIntStateOf(0) }

    Column {
        Button(onClick = { openDialog = true }) {
            Text(text = "Open Dialog")
        }
        Text(text = "Counter: $counter")
    }

    if (openDialog) {
        CustomAlertDialog(
            onDismiss = { openDialog = false },
            onConfirm = {
                counter++
                openDialog = false
            }
        )
    }
}

@Composable
fun CustomAlertDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = onConfirm,
            ) {
                Text(text = "Plus")
            }
        }, dismissButton = {
            Button(onClick = onDismiss) {
                Text(text = "Cancel")
            }
        }, icon = {
            Icon(
                Icons.Default.Add,
                ""
            )
        }, title = {
            Text("Plus")
        }, text = {
            Text("Please click the button")
        })
}


@Preview(showBackground = true)
@Composable
fun AlertDialogPreview() {
    ComposeStudyTheme {
//        AlertDialogExample()
        CustomAlertDialog({}, {})
    }
}