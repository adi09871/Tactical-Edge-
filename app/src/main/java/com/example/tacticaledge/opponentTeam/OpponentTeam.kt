package com.example.tacticaledge.opponentTeam
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tacticaledge.ui.theme.greenlight

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun OpponentTeamScreen(navController: NavController, context: Context){

    var teamName by remember { mutableStateOf("") }
    var formation by remember { mutableStateOf("") }
    var playstyle by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(greenlight)
    ){

        Text(text = "Opponent Team",
            color = androidx.compose.ui.graphics.Color.White,
            fontSize = 16.sp, fontWeight =  FontWeight.Bold,
            modifier = Modifier.padding(bottom = 6.dp)
            )

        OutlinedTextField(
            value = "",
            onValueChange = {},
label = {Text(text = "Team Name ")},
            colors = OutlinedTextFieldDefaults.colors(
focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),modifier = Modifier.fillMaxWidth().
            background(greenlight),
            shape = RoundedCornerShape(8.dp)


        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Formation ",
            color = androidx.compose.ui.graphics.Color.White,
            fontSize = 16.sp, fontWeight =  FontWeight.Bold,
            modifier = Modifier.padding(bottom = 6.dp)
        )


        OutlinedTextField(
            value = formation,
            onValueChange = {formation = it},
            label = { Text(text = "Formation") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth().
            background(greenlight),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Playstyle ",
            color = androidx.compose.ui.graphics.Color.White,
            fontSize = 16.sp, fontWeight =  FontWeight.Bold,
            modifier = Modifier.padding(bottom = 6.dp)
        )


        OutlinedTextField(
            value = playstyle,
            onValueChange = {playstyle = it},
            label = { Text(text = "Formation") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth().
            background(greenlight),
            shape = RoundedCornerShape(8.dp)

        )
        Button(
            onClick = {
                FirebaseManager.saveOpponentTeam(
                    teamName = teamName,
                    formation = formation,
                    playstyle = playstyle,
                    onSuccess = {
                        Toast.makeText(context, "Opponent team saved!", Toast.LENGTH_SHORT).show()
                        navController.navigate("next_screen_name") // optional
                    },
                    onFailure = {
                        Toast.makeText(context, "Failed to save: ${it.message}", Toast.LENGTH_SHORT).show()
                    }
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text("Save Opponent Team")
        }
    }

}