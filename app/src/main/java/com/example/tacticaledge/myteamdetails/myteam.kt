package com.example.tacticaledge.myteamdetails

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tacticaledge.homescreen.Firebase.FirebaseManager

import com.example.tacticaledge.ui.theme.greenlight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Myteam(navController: NavController) {
    val context = LocalContext.current
    Scaffold(topBar = { Apptopbar(navController
    = navController, title = "My Team") },) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(greenlight)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var teamName by remember { mutableStateOf("") }
            var startingXI by remember { mutableStateOf("") }
            var substitutes by remember { mutableStateOf("") }
            var strengths by remember { mutableStateOf("") }
            var weaknesses by remember { mutableStateOf("") }
            var playerName by remember { mutableStateOf("") }
           OutlinedTextField(
               value = teamName,
               onValueChange = {teamName = it},
               label = { Text("Team Name") },
               modifier = Modifier.fillMaxWidth(),
               colors = OutlinedTextFieldDefaults.colors(
                   focusedTextColor = Color.White,
                   unfocusedTextColor = Color.White,
                           focusedBorderColor = Color.Green,
                   unfocusedBorderColor = Color.Gray,
           )
                )


            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "playername", color = Color.White)


     OutlinedTextField(

         value = playerName,
         onValueChange = { playerName = it },
         label = { Text("Player Name") },
         modifier = Modifier.fillMaxWidth(),
         colors = OutlinedTextFieldDefaults.colors(
             focusedTextColor = Color.White,
             unfocusedTextColor = Color.White,
                     focusedBorderColor = Color.Green,
             unfocusedBorderColor = Color.Gray,
         )


                )


            Text(text = "Starting XI", color = Color.White)
            OutlinedTextField(
                value = startingXI,
                onValueChange = {startingXI = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = { Text("Enter starting players") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Gray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(12.dp))


            Text(text = "Substitutes", color = Color.White)
            OutlinedTextField(
                value = substitutes,
                onValueChange = { substitutes = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = { Text("Enter substitute players") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Gray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(12.dp))


            Text(text = "Strengths", color = Color.White)
            OutlinedTextField(
                value = strengths,
                onValueChange = {strengths = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = { Text("Enter team strengths") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Gray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(12.dp))


            Text(text = "Weaknesses", color = Color.White)
            OutlinedTextField(
                value = weaknesses,
                onValueChange = {weaknesses = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                placeholder = { Text("Enter team weaknesses") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Gray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )


            Button(onClick = {
                FirebaseManager.saveTeam(
                    team = teamName,
                    startingXI = startingXI,
                    substitutes = substitutes,
                    strengths = strengths,
                    weaknesses = weaknesses,
                    playerName = playerName,
                    onSuccess = {
                        Toast.makeText(context, "Team Saved!", Toast.LENGTH_SHORT).show()
                    },
                    onFailure = {
                        Toast.makeText(context, "Failed: ${it.message}", Toast.LENGTH_SHORT).show()
                    }

                )
            }) {
                Text("Save Team")
            }
        }}}

