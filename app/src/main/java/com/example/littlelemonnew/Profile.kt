package com.example.littlelemonnew

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littlelemonnew.ui.theme.Primary2
import com.example.littlelemonnew.ui.theme.Secondary4

@Composable
fun Profile(navController: NavController){
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)
    val first = sharedPreferences.getString("First Name", "No First Name Provided")
    val last = sharedPreferences.getString("Last Name", "No Last Name Provided")
    val email = sharedPreferences.getString("Email", "No Email Provided")
    Column (verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    )
    {
        Column {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
                    .height(50.dp))
            Text(text = "\n\n\n\n")
            Text(text = "Personal Information", fontWeight = FontWeight.Bold)
            Text(text = "\n\n")
            Text(text = "First Name")
            Text(text = first.toString())
            Text(text = "\n")
            Text(text = "Last Name")
            Text(text = last.toString())
            Text(text = "\n")
            Text(text = "Email")
            Text(text = email.toString())
            Text(text = "\n\n\n\n\n")
            Button(onClick =
            {
                // remove user data stored in shared preferences and navigate back to onboarding page
                sharedPreferences.edit().remove("First Name").apply()
                sharedPreferences.edit().remove("Last Name").apply()
                sharedPreferences.edit().remove("Email").apply()
                Toast.makeText(context,"Logging Out", Toast.LENGTH_SHORT).show()
                navController.navigate(Onboarding.route)

            },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Primary2))
            {
                Text(text = "Logout", color = Secondary4, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun PShow(){
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)
    val first = sharedPreferences.getString("First Name", "No First Name Provided")
    val last = sharedPreferences.getString("Last Name", "No Last Name Provided")
    val email = sharedPreferences.getString("Email", "No Email Provided")
    Column (verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    )
    {
        Column {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
                    .height(50.dp))
            Text(text = "\n\n\n\n")
            Text(text = "Personal Information", fontWeight = FontWeight.Bold)
            Text(text = "\n\n")
            Text(text = "First Name")
            Text(text = first.toString())
            Text(text = "\n")
            Text(text = "Last Name")
            Text(text = last.toString())
            Text(text = "\n")
            Text(text = "Email")
            Text(text = email.toString())
            Text(text = "\n\n\n\n\n")
            Button(onClick =
            {
                sharedPreferences.edit().remove("First Name").apply()
            },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Primary2))
            {
                Text(text = "Logout", color = Secondary4, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview(){
    PShow()
}