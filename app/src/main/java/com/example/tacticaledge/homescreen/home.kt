package com.example.tacticaledge.homescreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tacticaledge.ui.theme.green3

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navcontroller: NavController)
{
    Scaffold(

        bottomBar = { Bottombar() }
    ) { paddingValues ->
    Column(
        modifier = Modifier
            .fillMaxSize()  .padding(paddingValues)
            .background(color = Color(0xFF003300)) ,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(green3),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Tactical Edge",
                color = Color.White,
                modifier = Modifier.padding(top = 30.dp),
            )

            Text(
                text = "Welcome to Tactical Edge",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Analyze your team's Performance, scout opponents and get AI-powered tactical recommendations",
                color = Color.LightGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
Button(onClick = { navcontroller.navigate("myteam") }) {
Text(text = "add team details")

        }}}}}

