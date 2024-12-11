package we.study.composestudy.ui.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun SnackbarExample() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Box(modifier = Modifier.fillMaxSize()) {
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(16.dp)
        )

        Button(modifier = Modifier.align(Alignment.Center),
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Hello, Snackbar!",
                        actionLabel = "Undo",
                        withDismissAction = true
                    )
                }
            }) {
            Text("Show Snackbar")
        }
    }
}

@Composable
fun SnackbarWithScaffoldExample() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    }, floatingActionButton = {
        ExtendedFloatingActionButton(
            text = { Text("Show snackbar") },
            icon = { Icon(Icons.Filled.Email, contentDescription = "") },
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(message = "Snackbar")
                }
            }
        )
    }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            repeat(10) {
                Text(text = "Hello heegun")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SnackbarPreview() {
    ComposeStudyTheme {
        SnackbarExample()
    }
}