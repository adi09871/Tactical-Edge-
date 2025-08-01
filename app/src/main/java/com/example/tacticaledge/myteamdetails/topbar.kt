package com.example.tacticaledge.myteamdetails

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.tacticaledge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Apptopbar(
    navController: NavController,
    showBackButton: Boolean = true,
    navigateTo: String = "home",
    title: String
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "My Team ")
        },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = {
                    navController.navigate(navigateTo) {
                        popUpTo(navigateTo) { inclusive = true }
                    }
                }) {
                    Icon(

painter = painterResource(id = R.drawable.backarrow),contentDescription = null
                    )
                }
            }
        },
    )

}