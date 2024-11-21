package we.study.composestudy.ui.example

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import we.study.composestudy.R
import we.study.composestudy.model.ItemData
import we.study.composestudy.model.defaultItems
import we.study.composestudy.ui.theme.ComposeStudyTheme

@Composable
fun CatalogExample(itemList: List<ItemData>) {
    LazyColumn {
        items(itemList) { item ->
            Item(item)
        }
    }
}

@Composable
fun Item(itemData: ItemData) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp).size(200.dp)
        ) {
            Image(
                painterResource(itemData.imageId),
                contentDescription = "dog1",
                modifier = Modifier.size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = itemData.title,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = itemData.description,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ItemPreview() {
    ComposeStudyTheme {
        Item(
            ItemData(
                imageId = R.drawable.dog1,
                title = "강아지 1",
                description = "강아지1이다.강아지1이다.강아지1이다.강아지1이다.강아지1이다."
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemsPreview() {
    ComposeStudyTheme {
        CatalogExample(defaultItems)
    }
}



