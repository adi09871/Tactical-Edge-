package com.example.tacticaledge


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tacticaledge.homescreen.HomeScreen
import com.example.tacticaledge.myteamdetails.Myteam
<<<<<<< HEAD
import com.example.tacticaledge.opponentTeam.OpponentTeamScreen
=======
>>>>>>> c27995bdfd2dedc6fea74a8493013d3c3cb295a2
import com.google.firebase.FirebaseApp


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this  )

        setContent {
            MaterialTheme {



 val navController = rememberNavController()
            NavHost(navController, startDestination = "home") {
                composable("home") {
                    HomeScreen(navController)
                }
                composable("Myteam"){

                    Myteam(navController = navController)
                }

                composable("opponentTeam")
                { OpponentTeamScreen(navController = navController, context = this@MainActivity) }
        }
        }}}}






