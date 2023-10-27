package com.example.littlelemonnew

import android.content.Context.MODE_PRIVATE
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("Little Lemon", MODE_PRIVATE)
    // check if a first name is stored in shared preferences, if not send to onboarding
    val start = sharedPreferences.getString("First Name", "Onboarding")
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =
        if(start=="Onboarding"){Onboarding.route}
        else{Home.route}
     )
    {
        composable(Onboarding.route){
            Onboarding(navController)
        }
        composable(Home.route){
            Home(navController)
        }
        composable(Profile.route){
            Profile(navController)
        }

    }

}