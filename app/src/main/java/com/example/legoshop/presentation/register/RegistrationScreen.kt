package com.example.legoshop.presentation.register

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.legoshop.R
import com.example.legoshop.presentation.ViewModelFactoryHelper
import com.example.legoshop.ui.theme.LegoShopAppTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel = viewModel(factory = ViewModelFactoryHelper.Factory),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        RegistrationBody(
            viewModel = viewModel,
            modifier = modifier.padding(top = 32.dp)
        )
    }
}

@Composable
fun RegistrationBody(
    viewModel: RegistrationViewModel,
    modifier: Modifier = Modifier
) {
    var username by rememberSaveable { mutableStateOf("") }
    var emailAddress by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Image(
            painterResource(id = R.drawable.lego_computer_programmer_cmf),
            contentDescription = ""
        )

        Text(
            text = "Sign Up",
            fontSize = 40.sp
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") },
            modifier = Modifier.width(300.dp)
        )

        OutlinedTextField(
            value = emailAddress,
            onValueChange = { emailAddress = it },
            label = { Text(text = "Email Address") },
            modifier = Modifier.width(300.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            modifier = Modifier.width(300.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                    viewModel.registerUser(
                        username = username,
                        email = emailAddress,
                        password = password
                    )
                    
                    viewModel.addAccount(username, emailAddress)
                }

                showSuccessfulToastMessage(context, "Account successfully created!")
            },
            modifier = Modifier
                .height(50.dp)
                .width(300.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Create Account")
        }
    }
}

fun showSuccessfulToastMessage(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    LegoShopAppTheme {
        RegistrationScreen()
    }
}