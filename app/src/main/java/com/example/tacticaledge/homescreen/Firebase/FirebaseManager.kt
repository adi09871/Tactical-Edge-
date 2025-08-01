package com.example.tacticaledge.homescreen.Firebase




import com.example.tacticaledge.models.TeamData
import com.google.firebase.database.FirebaseDatabase

object FirebaseManager {





        fun saveTeam(
            team: String,
            startingXI: String,
            substitutes: String,
            strengths: String,
            weaknesses: String,
            playerName: String,
            onSuccess: () -> Unit,
            onFailure: (Exception) -> Unit
        ) {
            val database = FirebaseDatabase.getInstance().reference
            val teamId = database.child("teams").push().key ?: return

            val teamData = TeamData(
                teamName = team,
                startingXI = startingXI,
                substitutes = substitutes,
                strengths = strengths,
                weaknesses = weaknesses,
                playerName = playerName,
            )

            database.child("teams").child(teamId).setValue(teamData)
                .addOnSuccessListener { onSuccess() }
                .addOnFailureListener { onFailure(it) }
        }
    }
