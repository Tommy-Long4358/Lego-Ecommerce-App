package com.example.legoshop.presentation.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.legoshop.R
import com.example.legoshop.ui.theme.LegoShopAppTheme

@Composable
fun RegistrationScreen(modifier: Modifier = Modifier) {
    Scaffold(
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
               Image(
                    painterResource(id = R.drawable.lego_computer_programmer_cmf),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Sign Up",
                    fontSize = 40.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Email Address") },
                    modifier = Modifier.width(300.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Password") },
                    modifier = Modifier.width(300.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Re-enter Password") },
                    modifier = Modifier.width(300.dp)
                )
            }
            Spacer(modifier = Modifier.height(52.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .height(50.dp)
                        .width(300.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Create Account")
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    LegoShopAppTheme {
        RegistrationScreen()
    }
}