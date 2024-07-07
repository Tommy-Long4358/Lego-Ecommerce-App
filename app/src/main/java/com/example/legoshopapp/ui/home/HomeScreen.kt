package com.example.legoshopapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.legoshopapp.data.ItemsRepository
import com.example.legoshopapp.ui.theme.LegoShopAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold (
        topBar = {
            HomeTopAppBar()
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(start = 4.dp, top = 12.dp)
        ) {
            SectionRowGrid(
                sectionTitle = "Browse by Theme",
                section = "theme"
            )

            Spacer(modifier = Modifier.height(20.dp))

            SectionRowGrid(
                sectionTitle = "Your Recent Searches",
                section = "search"
            )

            Spacer(modifier = Modifier.height(32.dp))

            RecommendedSection()
        }
    }
}

@Composable
fun SearchBar() {

}

@Composable
fun SectionRowGrid(
    sectionTitle: String,
    section: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = sectionTitle
    )
    Spacer(modifier = Modifier.height(20.dp))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(ItemsRepository.items) {
            when(section) {
                "theme" -> ThemeCard()
                "search" -> ItemCard(
                    title = it.name,
                    price = it.price,
                    img = it.imgSrc,
                    modifier = Modifier
                        .width(120.dp)
                        .height(180.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "BrickStud"
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 12.dp)
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp)
            )
        }
    )
}


@Composable
fun ThemeCard(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(60.dp)
    ) {
        /*
        Image(
            painterResource(id = R.drawable.star_wars_logo),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
         */
    }
}

@Composable
fun ItemCard(
    title: String,
    price: String,
    img: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(110.dp),
    ) {
        Card(
            modifier = Modifier
                .width(120.dp)
                .height(120.dp),
        ) {
            Image(
                painterResource(id = img),
                contentDescription = "",
                contentScale = ContentScale.FillHeight
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            modifier = Modifier.padding(start = 4.dp)
        )

        Text(
            text = price,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun RecommendedSection(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(start = 12.dp)
    ) {
        Text(
            text = "Recommended For You"
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(ItemsRepository.items) { item ->
                ItemCard(
                    title = item.name,
                    price = item.price,
                    img = item.imgSrc,
                    modifier = Modifier
                        .height(180.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LegoShopAppTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ThemeCardPreview() {
    LegoShopAppTheme {
        ThemeCard()
    }
}

@Preview(showBackground = true)
@Composable
fun ItemCardPreview() {
    LegoShopAppTheme {

    }
}