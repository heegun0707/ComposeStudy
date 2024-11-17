package we.study.composestudy.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun ButtonComponent(onButtonClicked: () -> Unit, modifier: Modifier = Modifier) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = onButtonClicked,
//        onClick = { isPressed.value = !isPressed.value },
        modifier = modifier.size(150.dp, 60.dp),
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed) Color.Black else Color.White,
            contentColor = if (isPressed) Color.Red else Color.Blue
        ),
        border = BorderStroke(2.dp, Color.Magenta),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(10.dp),
        interactionSource = interactionSource
    ) {
        Icon(
            imageVector = Icons.Outlined.Send,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Send")
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ComposeStudyTheme {
        ButtonComponent( {} )
    }
}