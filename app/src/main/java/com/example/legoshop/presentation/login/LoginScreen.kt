package com.example.legoshop.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.legoshop.R
import com.example.legoshop.ui.theme.LegoShopAppTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = {
            LoginBottomAppBar()
        }
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
                    painterResource(id = R.drawable.lego_head_1),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Log In",
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
                    Text(text = "Log in")
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "forgot password?",
                fontSize = 16.sp,
                textAlign = TextAlign.Right,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 50.dp)
            )
        }
    }
}

@Composable
fun LoginBottomAppBar(modifier: Modifier = Modifier) {
    BottomAppBar(
        containerColor = Color.White
    ){
        Column(

        ) {
            Text(
                text = "Don't have an account?",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Sign Up",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LegoShopAppTheme {
        LoginScreen()
    }
}