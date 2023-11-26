package com.riezki.jetcoffeappui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.riezki.jetcoffeappui.model.Category
import com.riezki.jetcoffeappui.model.dummyCategory
import com.riezki.jetcoffeappui.ui.component.CategoryItem
import com.riezki.jetcoffeappui.ui.component.Search
import com.riezki.jetcoffeappui.ui.component.SectionText
import com.riezki.jetcoffeappui.ui.theme.JetCoffeAppUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeAppUITheme {
                // A surface container using the 'background' color from the theme
                JetCoffeeApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun JetCoffeeApp() {
    Scaffold {
        Column {
            Banner(modifier = Modifier.padding(it))
            SectionText(title = stringResource(id = R.string.section_category))
            CategoryRow()
        }
    }

}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )

        Search()
    }
}

@Composable
fun CategoryRow(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        items(
            dummyCategory,
            key = {
                it.textCategory
            }
        ) {category ->  
            CategoryItem(category = category)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CategoryRowPreview() {
    JetCoffeAppUITheme {
        CategoryRow()
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_3A_XL)
@Composable
fun GreetingPreview() {
    JetCoffeAppUITheme {
        JetCoffeeApp()
    }
}