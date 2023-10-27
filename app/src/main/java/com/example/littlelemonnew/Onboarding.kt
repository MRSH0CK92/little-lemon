package com.example.littlelemonnew

import android.content.Context.MODE_PRIVATE
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littlelemonnew.ui.theme.Primary1
import com.example.littlelemonnew.ui.theme.Primary2
import com.example.littlelemonnew.ui.theme.Secondary3

@Composable
fun Onboarding(navController: NavController){
    val context = LocalContext.current
    // get the stored variables for the app
    val sharedPreferences = context.getSharedPreferences("Little Lemon", MODE_PRIVATE)

    var firstName by rememberSaveable {
        mutableStateOf("")
    }
    var lastName by rememberSaveable {
        mutableStateOf("")
    }
    var email by rememberSaveable {
        mutableStateOf("")
    }

    Column (verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(10.dp)
            ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            alignment = Alignment.Center)
        Text(text = "\nLets get to know you",
            modifier = Modifier
                .background(Primary1)
                .fillMaxWidth()
                .height(80.dp)
            ,
            color = Secondary3,
            textAlign = TextAlign.Center,
            )
        Text(text = "\n\nPersonal Information\n\n",
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Bold
        )
        Text(text = "First Name",
            modifier = Modifier.fillMaxWidth())
        TextField(value = firstName,
            onValueChange = {firstName = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "First Name")})
        Text(text = "\n")
        Text(text = "Last Name", modifier = Modifier.fillMaxWidth())
        TextField(value = lastName,
            onValueChange = {lastName = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Last Name")})
        Text(text = "\n")
        Text(text = "Email", modifier = Modifier.fillMaxWidth())
        TextField(value = email,
            onValueChange = {email = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Email Address")},
            )
        Text(text = "\n\n\n")
        Button(onClick =
        {
            if(firstName==""||lastName==""||email==""){
                Toast.makeText(context,"Registration unsuccessful. Please enter all data.",Toast.LENGTH_SHORT).show()
            }
            else {
                // save the input in the shared preferences so app will remember
                sharedPreferences.edit().putString("First Name",firstName).apply()
                sharedPreferences.edit().putString("Last Name",lastName).apply()
                sharedPreferences.edit().putString("Email",email).apply()
                Toast.makeText(context,"Registration successful, Welcome $firstName, to Little Lemon",Toast.LENGTH_SHORT).show()
                // navigate to home screen
                navController.navigate(Home.route)
            }
        },
            colors = ButtonDefaults.buttonColors(Primary2),
            modifier = Modifier.fillMaxWidth())
        {
            Text(text = "Register")
        }
    }
}


