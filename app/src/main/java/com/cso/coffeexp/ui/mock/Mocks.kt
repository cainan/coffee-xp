package com.cso.coffeexp.ui.mock

import com.cso.coffeexp.data.Coffee

val mockCoffeeData = listOf(
    Coffee(
        name = "Ethiopian Yirgacheffe",
        method = "Chemex",
        grade = 4.8f,
        imageUrl = "https://picsum.photos/seed/yirgacheffe/400/300"
    ),
    Coffee(
        name = "Colombian Supremo",
        method = "French Press",
        grade = 4.5f,
        imageUrl = "https://picsum.photos/seed/supremo/400/300"
    ),
    Coffee(
        name = "Brazilian Santos",
        method = "Espresso",
        grade = 4.2f
    )
)

//fun getSampleCoffeeData(): List<Coffee> {
//    return listOf(
//        Coffee(
//            name = "Ethiopian Yirgacheffe",
//            method = "Chemex",
//            grade = 4.8f,
//            imageUrl = "https://picsum.photos/seed/yirgacheffe/400/300"
//        ),
//        Coffee(
//            name = "Colombian Supremo",
//            method = "French Press",
//            grade = 4.5f,
//            imageUrl = "https://picsum.photos/seed/supremo/400/300"
//        ),
//        Coffee(
//            name = "Brazilian Santos",
//            method = "Espresso",
//            grade = 4.2f
//        ) // No image for this one
//    )
//}