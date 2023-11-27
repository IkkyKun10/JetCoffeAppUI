package com.riezki.jetcoffeappui.model

import androidx.compose.ui.res.stringResource
import com.riezki.jetcoffeappui.R

data class Menu(
    val image: Int,
    val title: String,
    val price: String,
)

val dummyMenu = listOf(
    Menu(
        R.drawable.menu1,
        "Tiramisu Coffee Milk",
        "Rp. 28.000"
    ),
    Menu(
        R.drawable.menu2,
        "Tiramisu Coffee Milky",
        "Rp. 28.000"
    ),
    Menu(
        R.drawable.menu3,
        "Tiramisu Coffee Milkyse",
        "Rp. 28.000"
    ),
    Menu(
        R.drawable.menu4,
        "Tiramisu Coffee Milkbyuufj",
        "Rp. 28.000"
    ),
)
