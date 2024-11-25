package we.study.composestudy.model

data class CardData(
    val imageUri: String,
    val description: String,
    val imageName: String
)
val defaultCards = listOf(
    CardData(
        imageUri = "https://www.pexels.com/ko-kr/photo/29137971/",
        description = "large rock large rock large rock large rock large rock large rock",
        imageName = "rock"
    ),
    CardData(
        imageUri = "https://www.pexels.com/ko-kr/photo/29137971/",
        description = "large rock large rock large rock large rock large rock large rock",
        imageName = "rock"
    ),
    CardData(
        imageUri = "https://www.pexels.com/ko-kr/photo/29137971/",
        description = "large rock large rock large rock large rock large rock large rock",
        imageName = "rock"
    ),
    CardData(
        imageUri = "https://www.pexels.com/ko-kr/photo/29137971/",
        description = "large rock large rock large rock large rock large rock large rock",
        imageName = "rock"
    )
)