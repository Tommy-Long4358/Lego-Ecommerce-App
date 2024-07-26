package com.example.legoshop.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.legoshop.ui.theme.LegoShopAppTheme
import com.example.legoshop.R
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
    val homeUiState = viewModel.state
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold (
        topBar = {
            HomeTopAppBar(title = "BrickStud")
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            HomeBody(
                contentPadding = innerPadding,
                state = homeUiState,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun HomeBody(
    contentPadding: PaddingValues = PaddingValues(0.dp),
    state: HomeUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(contentPadding),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        SearchBar()

        /*
        SectionRow(
            sectionTitle = "Browse by Theme",
            section = "theme",
            modifier = Modifier.padding(start = 8.dp)
        )
        SectionRow(
            sectionTitle = "Your Recent Searches",
            section = "search",
            modifier = Modifier.padding(start = 8.dp)
        )

         */

        RecommendedSection(
            modifier = Modifier.padding(start = 8.dp),
            state = state
        )
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
            .width(390.dp)
            .height(64.dp)
            .padding(start = 8.dp, end = 8.dp)
    )
}

@Composable
fun SectionRow(
    sectionTitle: String,
    section: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = sectionTitle)

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            /*
            items(ItemsRepository.items) {
                when(section) {
                    "theme" -> ThemeCard(
                        modifier = Modifier
                            .width(100.dp)
                            .height(60.dp),
                    )
                    "search" -> ItemCard(
                        title = it.name,
                        price = it.price,
                        img = it.imgSrc,
                        modifier = Modifier
                            .size(120.dp),
                        onItemClick = onItemClick
                    )
                }
            }

             */
        }
    }
}

@Composable
fun RecommendedSection(
    modifier: Modifier = Modifier,
    state: HomeUiState
) {
    val itemListings = state.itemListings
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "Recommended For You"
        )
        Spacer(modifier = Modifier.height(20.dp))

        if (itemListings.isEmpty()) {
            Text(
                text = "Total number of item listings: " + itemListings.size.toString()
            )
        }
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
fun ItemCard(
    title: String,
    price: String,
    img: Int,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .clickable(onClick = onItemClick)
    ) {
        Card(
            modifier = modifier
        ) {
            Image(
                painterResource(id = img),
                contentDescription = "",
                contentScale = ContentScale.FillHeight
            )
        }
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LegoShopAppTheme {
        HomeScreen()
    }
}
