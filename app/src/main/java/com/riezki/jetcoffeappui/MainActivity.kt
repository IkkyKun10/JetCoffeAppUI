package com.riezki.jetcoffeappui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.riezki.jetcoffeappui.model.BottomBarDataItem
import com.riezki.jetcoffeappui.model.Menu
import com.riezki.jetcoffeappui.model.dummyCategory
import com.riezki.jetcoffeappui.model.dummyMenu
import com.riezki.jetcoffeappui.ui.component.CategoryItem
import com.riezki.jetcoffeappui.ui.component.HomeSection
import com.riezki.jetcoffeappui.ui.component.MenuItem
import com.riezki.jetcoffeappui.ui.component.Search
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
    Scaffold(
        bottomBar = { BottomBar() }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(it)
        ) {
            Banner()
            HomeSection(
                title = stringResource(id = R.string.section_category),
                content = {
                    CategoryRow()
                }
            )
            HomeSection(
                title = stringResource(id = R.string.menu_favorite),
                content = { MenuRow(listMenu = dummyMenu) }
            )
            HomeSection(
                title = stringResource(id = R.string.section_best_seller_menu),
            ) {
                MenuRow(listMenu = dummyMenu)
            }
        }
    }

}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier,
    ) {
        val navigationItems = listOf<BottomBarDataItem>(
            BottomBarDataItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
            ),
            BottomBarDataItem(
                title = stringResource(id = R.string.menu_favorite),
                icon = Icons.Default.Favorite,
            ),
            BottomBarDataItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.AccountCircle,
            ),
        )

        navigationItems.map {
            NavigationBarItem(
                selected = it.title == navigationItems[0].title,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) },
                label = { Text(text = it.title) }
            )
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
        ) { category ->
            CategoryItem(category = category)
        }
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = { it.title }) { menu ->
            MenuItem(menu = menu)
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

@Preview(showBackground = true)
@Composable
fun JetCoffeePreview() {
    JetCoffeAppUITheme {
        JetCoffeeApp()
    }
}