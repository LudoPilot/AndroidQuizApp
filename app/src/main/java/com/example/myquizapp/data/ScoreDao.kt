package com.example.myquizapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(score: Score): Long

//    @Query("SELECT * FROM score_table")
//    fun getAllScores(): Flow<List<Score>>

    @Query("SELECT pseudo, MAX(score) as score FROM score_table GROUP BY pseudo ORDER BY score DESC")
    fun getBestScores(): Flow<List<BestScore>>
}
