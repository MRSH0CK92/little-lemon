package com.example.littlelemonnew

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController){
    Column (verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row {
            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .clickable
                    {
                        navController.navigate(Profile.route)
                    },
                alignment = Alignment.TopEnd)
        }
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription ="Little Lemon Logo",
            modifier = Modifier
                .fillMaxSize(),
            alignment = Alignment.Center
        )
    }
}

@Composable
fun HomeP(){
    Column (verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row {
            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .clickable {  },
                alignment = Alignment.TopEnd)
        }
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription ="Little Lemon Logo",
            modifier = Modifier
                .fillMaxSize(),
            alignment = Alignment.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    HomeP()
}