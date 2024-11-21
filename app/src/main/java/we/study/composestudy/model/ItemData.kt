package we.study.composestudy.model

import we.study.composestudy.R

data class ItemData(
    val imageId: Int,
    val title: String,
    val description: String
)
val defaultItems = listOf(
    ItemData(
        imageId = R.drawable.dog1,
        title = "강아지 1",
        description = "강아지1이다.강아지1이다.강아지1이다.강아지1이다.강아지1이다."
    ),
    ItemData(
        imageId = R.drawable.dog2,
        title = "강아지 2",
        description = "강아지2이다.강아지2이다.강아지2이다.강아지2이다.강아지2이다."
    ),
    ItemData(
        imageId = R.drawable.dog3,
        title = "강아지 3",
        description = "강아지3이다.강아지3이다.강아지3이다.강아지3이다.강아지3이다."
    ),
    ItemData(
        imageId = R.drawable.dog4,
        title = "강아지 4",
        description = "강아지4이다.강아지4이다.강아지4이다.강아지4이다.강아지4이다."
    ),
    ItemData(
        imageId = R.drawable.dog5,
        title = "강아지 5",
        description = "강아지5이다.강아지5이다.강아지5이다.강아지5이다.강아지5이다."
    )
)
