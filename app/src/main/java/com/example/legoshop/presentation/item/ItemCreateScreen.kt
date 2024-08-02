package com.example.legoshop.presentation.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.legoshop.presentation.ViewModelFactoryHelper
import com.example.legoshop.presentation.home.HomeTopAppBar
import com.example.legoshop.ui.theme.LegoShopAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCreateScreen(
    viewModel: ItemCreateViewModel = viewModel(factory = ViewModelFactoryHelper.Factory),
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold (
        topBar = {
            HomeTopAppBar(title = "Edit")
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(state = rememberScrollState())
        ) {
            ItemInputForm(
                itemUiState = viewModel.itemUiState,
                onItemValueChange = viewModel::updateUiState, // pass in function that updates itemUiState
                onSaveClick = {
                    coroutineScope.launch {
                        viewModel.saveItem() // Once user posts a listing, it is saved into the database
                    }
                },
                modifier = modifier
            )
        }
    }
}

/**
 * Composable that displays a form to fill out a [ItemListing]
 * [itemUiState] is the UI state of an item
 * [onItemValueChange] lambda handles updating the [itemUiState] with the user's selections
 * [onSaveClick] lambda handles inserting [itemUiState] into the database
 */
@Composable
fun ItemInputForm(
    itemUiState: ItemUiState,
    onItemValueChange: (ItemListingDetails) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val options = listOf("Set", "Minifigure", "Other")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 12.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        /*
        Text(text = "What type of item?")

        Spacer(modifier = Modifier.height(12.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            TextField(
                value = selectedOptionText,
                onValueChange = {},
                modifier = Modifier
                    .menuAnchor()
                    .width(328.dp),
                readOnly = true,
                label = { Text("Label") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach {selectedOption ->
                    DropdownMenuItem(
                        text = { Text(selectedOption) },
                        onClick = {
                            selectedOptionText = selectedOption
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
         */
        SetInfoSection(
            itemListingDetails = itemUiState.itemListingDetails,
            onItemValueChange = onItemValueChange,
            modifier = modifier
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = onSaveClick,
                modifier = Modifier
                    .height(50.dp)
                    .width(300.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Post Listing")
            }
        }
    }
}

/**
 * Composable that displays a form to fill out a set's information
 * [itemListingDetails] is the details of an item
 * [onItemValueChange] lambda parses user selection to [itemListingDetails]
 */
@Composable
fun SetInfoSection(
    itemListingDetails: ItemListingDetails,
    onItemValueChange: (ItemListingDetails) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(text = "Title:")
        TextField(
            value = itemListingDetails.title,
            onValueChange = { onItemValueChange(itemListingDetails.copy(title = it)) }, // update itemlistingdetails with new value inputted
            modifier = Modifier.width(328.dp)
        )

        Text(text = "Price:")
        TextField(
            value = itemListingDetails.price,
            onValueChange = { onItemValueChange(itemListingDetails.copy(price = it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.width(328.dp)
        )

        Text(text = "Description:")
        TextField(
            value = itemListingDetails.description,
            onValueChange = { onItemValueChange(itemListingDetails.copy(description = it)) },
            modifier = Modifier.width(328.dp)
        )
    }
}

@Composable
fun MinifigureInfoSection(modifier: Modifier = Modifier) {
    TODO("To be implemented")
}

@Composable
fun BrickInfoSection(modifier: Modifier = Modifier) {
    TODO("To be implemented")
}

@Preview
@Composable
fun ItemCreateScreenPreview() {
    LegoShopAppTheme {
        ItemInputForm(
            itemUiState = ItemUiState(
                itemListingDetails = ItemListingDetails(
                    title = "Jedi Bob Starfighter",
                    price = "39.99",
                    description = "JEDI BOBBBBBBB!"
                )
            ),
            onItemValueChange = {},
            onSaveClick = {})
    }
}