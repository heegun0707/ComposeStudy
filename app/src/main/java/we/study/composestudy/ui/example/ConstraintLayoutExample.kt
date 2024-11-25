package we.study.composestudy.ui.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import we.study.composestudy.R
import we.study.composestudy.model.CardData
import we.study.composestudy.model.defaultCards
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .constrainAs(redBox) {
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .constrainAs(greenBox) {
                    centerTo(parent)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    top.linkTo(parent.top)
//                    bottom.linkTo(parent.bottom)
                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    start.linkTo(magentaBox.end)
                    top.linkTo(magentaBox.bottom)
                }
        )
    }
}

@Composable
fun ImageExampleComponent(cardData: CardData) {
    Card (
        modifier = Modifier.padding(4.dp),
        colors = CardColors(
            containerColor = Color.DarkGray,
            contentColor = Color.Green,
            disabledContainerColor = Color.Black,
            disabledContentColor = Color.Blue
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {

            val (profileImage, author, description) = createRefs()
            AsyncImage(
                model = cardData.imageUri,
                contentDescription = cardData.description,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(color = Color.LightGray),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp)
                    .constrainAs(profileImage) {
                        centerVerticallyTo(parent)
                        start.linkTo(parent.start, margin = 8.dp)
                        top.linkTo(parent.top, margin = 8.dp)
                    }
            )
            Text(
                text = cardData.imageName,
                modifier = Modifier.constrainAs(author) {
                    linkTo(
                        profileImage.end,
                        parent.end,
                        startMargin = 8.dp,
                        endMargin = 8.dp
                    )
//                top.linkTo(profileImage.top)
//                start.linkTo(profileImage.end, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
            )
            Text(
                text = cardData.description,
                modifier = Modifier.constrainAs(description) {
                    linkTo(
                        profileImage.end,
                        parent.end,
                        startMargin = 8.dp,
                        endMargin = 8.dp
                    )
//                top.linkTo(profileImage.top)
//                start.linkTo(profileImage.end, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
            )

            createVerticalChain(author, description, chainStyle = ChainStyle.Packed)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutPreview() {
    ComposeStudyTheme {
        LazyColumn {
            items(defaultCards) { cardData ->
                ImageExampleComponent(cardData = cardData)
            }
        }
    }
}