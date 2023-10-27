package com.example.littlelemonnew

import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations {
    val route: String
    val title: String
}

object Home: Destinations{
    override val route: String = "Home Screen"
    override val title: String = "Home"
}
object Profile: Destinations{
    override val route: String = "Profile Screen"
    override val title: String = "Profile"
}
object Onboarding: Destinations{
    override val route: String = "Onboarding Screen"
    override val title: String = "Onboarding"
}