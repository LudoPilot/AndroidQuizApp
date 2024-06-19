package com.example.myquizapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score_table")
data class Score(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val pseudo: String,
    val score: Int
)

// Meilleur score
data class BestScore(
    val pseudo: String,
    val score: Int
)