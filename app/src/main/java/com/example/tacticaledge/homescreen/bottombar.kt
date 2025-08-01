package com.example.tacticaledge.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tacticaledge.R
import com.example.tacticaledge.ui.theme.primarygreen



@Composable

fun Bottombar() {



    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth().background(primarygreen),
    )
    {
        // First Icon
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.teamicon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(text = "Team")
        }

        // Second Icon
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.oppicon),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(text = "Opponent")
        }//third icon
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.ai),
                contentDescription = null,
                modifier = Modifier.size(24.dp), tint = Color.Unspecified
            )
            Text(text = "AI prediction")
    }}}


