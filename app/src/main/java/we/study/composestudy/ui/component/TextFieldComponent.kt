package we.study.composestudy.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun TextFieldComponent() {
    var text by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(8.dp)) {
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                isError = newText.isEmpty() // 입력값이 비어있으면 에러 상태로 설정
            },
            label = { Text("이메일 주소") },
            placeholder = { Text("example@example.com") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email Icon") },
            trailingIcon = {
                if (isError) {
                    Icon(Icons.Default.Close, contentDescription = "Error")
                }
            },
            supportingText = { if (isError) Text("이메일 주소를 입력하세요.", color = Color.Red) },
            isError = isError,
//        visualTransformation = VisualTransformation.None,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            singleLine = true,
            shape = MaterialTheme.shapes.small,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Blue,
                unfocusedIndicatorColor = Color.Gray,
                errorIndicatorColor = Color.Red
            )
        )
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                isError = newText.isEmpty() // 입력값이 비어있으면 에러 상태로 설정
            },
            label = { Text("이메일 주소") },
            placeholder = { Text("example@example.com") },
//            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email Icon") },
//            trailingIcon = {
//                if (isError) {
//                    Icon(Icons.Default.Close, contentDescription = "Error")
//                }
//            },
//            supportingText = { if (isError) Text("이메일 주소를 입력하세요.", color = Color.Red) },
            isError = isError,
//            visualTransformation = VisualTransformation.None,
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
//            singleLine = true,
            shape = MaterialTheme.shapes.small,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Blue,
                unfocusedIndicatorColor = Color.Gray,
                errorIndicatorColor = Color.Red
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    ComposeStudyTheme {
        TextFieldComponent()
    }
}

