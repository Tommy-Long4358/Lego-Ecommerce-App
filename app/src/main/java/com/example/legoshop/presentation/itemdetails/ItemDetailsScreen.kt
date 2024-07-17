package com.example.legoshop.presentation.itemdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.legoshop.R
import com.example.legoshop.presentation.home.HomeTopAppBar
import com.example.legoshop.presentation.navigation.NavigationDestination
import com.example.legoshop.ui.theme.LegoShopAppTheme

object ItemDetailsDestination: NavigationDestination {
    override val route = "item"
    override val titleRes = "Item Details"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailScreen(modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold (
        topBar = {
            HomeTopAppBar(title = "Details")
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(state = rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = R.drawable.listing_1),
                contentDescription = null,
                modifier = Modifier.padding()
                // TODO: Set image to certain dimensions for all images
            )

            Spacer(modifier = Modifier.height(12.dp))

            ItemInformation()
        }
    }
}

@Composable
fun ItemInformation(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(start = 12.dp, end = 12.dp)
    ) {
        Text(
            text = "75212 Kessel Run Millennium Falcon",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "$179.99",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Condition: Used"
        )

        Spacer(modifier = Modifier.height(32.dp))
        Divider(color = Color.Gray, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))

        ItemDetails()

        Spacer(modifier = Modifier.height(32.dp))
        Divider(color = Color.Gray, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Catalog Description",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et " +
                    "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex " +
                    "ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
                    "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
                    "mollit anim id est laborum."
        )
    }
}

@Composable
fun ItemDetails(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Item Details",
            fontSize = 28.sp
        )
        Text(
            text = "Set Number: 75212" + "\n" +
                   "Name: Kessel Run Millenium Falcon" + "\n" +
                    "Theme: Star Wars" + "\n" +
                    "Released: April 14, 2018" + "\n" +
                    "Retired: February 13, 2020" + "\n" +
                    "Pieces: 1,414" + "\n" +
                    "Minifigures: 7",
            lineHeight = 32.sp
        )
        
        Text(
            text = "see more",
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemDetailScreenPreview() {
    LegoShopAppTheme {
        ItemDetailScreen()
    }
}