//////package com.example.myquizapp
//////
//////import android.content.Intent
//////import android.os.Bundle
//////import android.widget.Button
//////import android.widget.TextView
//////import androidx.appcompat.app.AppCompatActivity
//////import androidx.lifecycle.lifecycleScope
//////import com.example.myquizapp.data.QuizDatabase
//////import com.example.myquizapp.data.Score
//////import kotlinx.coroutines.Dispatchers
//////import kotlinx.coroutines.flow.collect
//////import kotlinx.coroutines.launch
//////
//////class ScoreActivity : AppCompatActivity() {
//////
//////    override fun onCreate(savedInstanceState: Bundle?) {
//////        super.onCreate(savedInstanceState)
//////        setContentView(R.layout.activity_score)
//////
//////        val textViewFinalScore: TextView = findViewById(R.id.textViewFinalScore)
//////        val buttonBackToLogin: Button = findViewById(R.id.buttonBackToLogin)
//////
//////        val score = intent.getIntExtra("SCORE", 0)
//////        textViewFinalScore.text = "Votre score : $score"
//////
//////        buttonBackToLogin.setOnClickListener {
//////            val intent = Intent(this, MainActivity::class.java)
//////            startActivity(intent)
//////        }
//////
//////        // Charger et afficher tous les scores
//////        lifecycleScope.launch {
//////            QuizDatabase.getDatabase(applicationContext).scoreDao().getAllScores().collect { scores ->
//////                displayScores(scores)
//////            }
//////        }
//////    }
//////
//////    private fun displayScores(scores: List<Score>) {
//////        val scoreListTextView: TextView = findViewById(R.id.scoreListTextView)
//////        val scoreText = scores.joinToString("\n") { "${it.pseudo}: ${it.score}" }
//////        scoreListTextView.text = scoreText
//////    }
//////}
////package com.example.myquizapp
////
////import android.content.Intent
////import android.os.Bundle
////import android.widget.Button
////import android.widget.TextView
////import androidx.appcompat.app.AppCompatActivity
////import androidx.lifecycle.lifecycleScope
////import com.example.myquizapp.data.QuizDatabase
////import com.example.myquizapp.data.Score
////import kotlinx.coroutines.Dispatchers
////import kotlinx.coroutines.flow.collect
////import kotlinx.coroutines.launch
////
////class ScoreActivity : AppCompatActivity() {
////
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContentView(R.layout.activity_score)
////
////        val textViewFinalScore: TextView = findViewById(R.id.textViewFinalScore)
////        val scoreListTextView: TextView = findViewById(R.id.scoreListTextView)
////        val buttonBackToLogin: Button = findViewById(R.id.buttonBackToLogin)
////
////        val score = intent.getIntExtra("SCORE", 0)
////        val totalQuestions = intent.getIntExtra("TOTAL_QUESTIONS", 0)
////
////        textViewFinalScore.text = "Votre score : $score / $totalQuestions"
////
////        buttonBackToLogin.setOnClickListener {
////            val intent = Intent(this, MainActivity::class.java)
////            startActivity(intent)
////        }
////
////        // Charger et afficher tous les scores
////        lifecycleScope.launch {
////            QuizDatabase.getDatabase(applicationContext).scoreDao().getAllScores().collect { scores ->
////                displayScores(scores)
////            }
////        }
////    }
////
////    private fun displayScores(scores: List<Score>) {
////        val scoreListTextView: TextView = findViewById(R.id.scoreListTextView)
////        val scoreText = scores.joinToString("\n") { "${it.pseudo}: ${it.score}" }
////        scoreListTextView.text = scoreText
////    }
////}
//package com.example.myquizapp
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.lifecycleScope
//import com.example.myquizapp.data.QuizDatabase
//import com.example.myquizapp.data.Score
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.collect
//import kotlinx.coroutines.launch
//
//class ScoreActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_score)
//
//        val textViewFinalScore: TextView = findViewById(R.id.textViewFinalScore)
//        val buttonBackToLogin: Button = findViewById(R.id.buttonBackToLogin)
//
//        val score = intent.getIntExtra("SCORE", 0)
//        val pseudo = intent.getStringExtra("PSEUDO") ?: "Unknown"
//
//        textViewFinalScore.text = "Votre score : $score"
//
//        buttonBackToLogin.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//
//        // Save the current score
//        lifecycleScope.launch {
//            saveScore(pseudo, score)
//        }
//
//        // Load and display all scores
//        lifecycleScope.launch {
//            QuizDatabase.getDatabase(applicationContext).scoreDao().getAllScores().collect { scores ->
//                displayScores(scores)
//            }
//        }
//    }
//
//    private suspend fun saveScore(pseudo: String, score: Int) {
//        val newScore = Score(pseudo = pseudo, score = score)
//        QuizDatabase.getDatabase(applicationContext).scoreDao().insert(newScore)
//    }
//
//    private fun displayScores(scores: List<Score>) {
//        val scoreListTextView: TextView = findViewById(R.id.scoreListTextView)
//        val scoreText = scores.joinToString("\n") { "${it.pseudo}: ${it.score}" }
//        scoreListTextView.text = scoreText
//    }
//}
package com.example.myquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myquizapp.data.BestScore
import com.example.myquizapp.data.QuizDatabase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val textViewFinalScore: TextView = findViewById(R.id.textViewFinalScore)
        val buttonBackToLogin: Button = findViewById(R.id.buttonBackToLogin)

        val score = intent.getIntExtra("SCORE", 0)
        textViewFinalScore.text = "Votre score : $score"

        buttonBackToLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Charger et afficher le meilleur score
        lifecycleScope.launch {
            QuizDatabase.getDatabase(applicationContext).scoreDao().getBestScores().collect { scores ->
                displayBestScore(scores)
            }
        }
    }

    private fun displayBestScore(scores: List<BestScore>) {
        val scoreListTextView: TextView = findViewById(R.id.scoreListTextView)
        val bestScore = scores.maxByOrNull { it.score }
        val scoreText = bestScore?.let { "Meilleur score : ${it.pseudo} avec ${it.score} points." } ?: "Pas de scores disponibles"
        scoreListTextView.text = scoreText
    }
}