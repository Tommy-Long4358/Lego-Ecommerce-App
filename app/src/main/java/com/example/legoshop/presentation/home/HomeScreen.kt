package com.example.legoshop.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.legoshop.ui.theme.LegoShopAppTheme
import com.example.legoshop.R
import com.example.legoshop.domain.model.ItemListing
import com.example.legoshop.presentation.ViewModelFactoryHelper

/** TODO
 * - A Lazy-style list can't be nested in another lazy list so another way must be found in achieving this.
 * - Implement bottom app bar. The bottom app bar will have a home button, a profile button, etc
 * - Add a "see-all" hyperlink to each section to show all results
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(factory = ViewModelFactoryHelper.Factory),
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold (
        topBar = {
            HomeTopAppBar(title = "BrickStud")
        },
        bottomBar = {
            HomeBottomAppBar()
        },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        HomeBody(
            contentPadding = innerPadding,
            homeUiState = viewModel.homeUiState,
        )
    }
}

@Composable
fun HomeBody(
    contentPadding: PaddingValues = PaddingValues(0.dp),
    homeUiState: HomeUiState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            SearchBar()
        }

        item {
            RecentSearchSection(
                sectionTitle = "Your Recent Searches",
                recentSearches = homeUiState.itemListings,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        item {
            RecommendedSection(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                itemListings = homeUiState.itemListings
            )
        }

    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = {
            Text(text = "Search")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        modifier = modifier
            .width(400.dp)
            .height(64.dp)
            .padding(start = 8.dp, end = 8.dp)
    )
}

@Composable
fun RecentSearchSection(
    sectionTitle: String,
    recentSearches: List<ItemListing>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TitleSection(sectionTitle = sectionTitle)

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.width(392.dp)
        ) {
            items(recentSearches) { item ->
                ItemCard(
                    title = item.title,
                    price = item.price.toString(),
                    img = R.drawable.listing_1,
                    modifier = Modifier
                        .height(130.dp)
                        .width(170.dp),
                    onItemClick = {}
                )
            }
        }
    }
}

@Composable
fun RecommendedSection(
    modifier: Modifier = Modifier,
    itemListings: List<ItemListing>
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TitleSection(sectionTitle = "Recommended for You")

        if (itemListings.isEmpty()) {
            Text(text = "No available listings")
        }
        else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.height(2000.dp)
            ) {
                items(itemListings) {
                    ItemCard(
                        title = it.title,
                        price = "$" + it.price.toString(),
                        img = R.drawable.listing_4,
                        onItemClick = {},
                        modifier = Modifier.size(200.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ItemCard(
    title: String,
    price: String,
    img: Int,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.clickable(onClick = onItemClick)
    ) {
        Card(
            modifier = modifier
        ) {
            Image(
                painterResource(id = img),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = title,
            maxLines = 1,
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
fun ThemeCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Image(
            painterResource(id = R.drawable.star_wars_logo),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun TitleSection(
    sectionTitle: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = sectionTitle,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "see all",
            modifier = Modifier.padding(top = 4.dp, end = 4.dp),
            fontSize = 12.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior? = null,
    title: String,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title
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
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
    )
}

@Composable
fun HomeBottomAppBar(modifier: Modifier = Modifier) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = null,
                modifier = Modifier.size(30.dp).weight(1f)
            )

            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                modifier = Modifier.size(30.dp).weight(1f)
            )

            Icon(
                imageVector = Icons.Filled.List,
                contentDescription = null,
                modifier = Modifier.size(30.dp).weight(1f)
            )

            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = null,
                modifier = Modifier.size(30.dp).weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeBottomAppBarPreview() {
    LegoShopAppTheme {
        HomeBottomAppBar()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LegoShopAppTheme {
        val homeUiState = HomeUiState(
            listOf(ItemListing("Jedi Bob Starfighter", 39.99, "JEDI BOB!"),
                ItemListing("Dark Millennium Falcon", 179.99, "DARTH JAR JAR!"),
                ItemListing("Kessel Run Millennium Falcon", 179.99, "NEVER TELL ME THE ODDS!"),
                ItemListing("Captain Rex Y-Wing Microfighter", 14.99, "ZOOOMMMM"))
        )

        HomeBody(homeUiState = homeUiState)
    }
}