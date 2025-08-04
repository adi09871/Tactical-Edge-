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
            playerName = playerName
        )

        database.child("teams").child(teamId).setValue(teamData)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure(it) }
    }

    fun saveOpponentTeam(
        teamName: String,
        formation: String,
        playstyle: String,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val database = FirebaseDatabase.getInstance().reference
        val teamId = database.child("opponent_teams").push().key ?: return

        val team = mapOf(
            "teamName" to teamName,
            "formation" to formation,
            "playstyle" to playstyle
        )

        database.child("opponent_teams").child(teamId).setValue(team)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure(it) }
    }

    fun fetchTeamsForPrediction(
        onSuccess: (myTeam: TeamData, opponentTeam: TeamData) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        val db = FirebaseDatabase.getInstance().reference

        db.child("teams").limitToLast(1).get().addOnSuccessListener { myTeamSnapshot ->
            val myTeam = myTeamSnapshot.children.first().getValue(TeamData::class.java)

            db.child("opponent_teams").limitToLast(1).get().addOnSuccessListener { opponentSnapshot ->
                val opponentTeam = opponentSnapshot.children.first().getValue(TeamData::class.java)

                if (myTeam != null && opponentTeam != null) {
                    onSuccess(myTeam, opponentTeam)
                } else {
                    onFailure(Exception("Data not found"))
                }

            }.addOnFailureListener { onFailure(it) }

        }.addOnFailureListener { onFailure(it) }
    }
}

