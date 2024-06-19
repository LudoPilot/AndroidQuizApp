//// QuizActivity.kt
//package com.example.myquizapp
//
//import android.content.Intent
//import android.os.Bundle
//import android.os.CountDownTimer
//import android.widget.Button
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import com.example.myquizapp.data.QuizQuestions
//import com.example.myquizapp.data.Question
//
//class QuizActivity : AppCompatActivity() {
//
//    private lateinit var textViewQuestion: TextView
//    private lateinit var textViewTimer: TextView
//    private lateinit var buttonOption1: Button
//    private lateinit var buttonOption2: Button
//    private lateinit var buttonOption3: Button
//    private lateinit var buttonOption4: Button
//
//    private lateinit var questionList: List<Question>
//    private var currentQuestionIndex: Int = 0
//    private var correctAnswersCount: Int = 0
//    private var timer: CountDownTimer? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_quiz)
//
//        textViewQuestion = findViewById(R.id.textViewQuestion)
//        textViewTimer = findViewById(R.id.textViewTimer)
//        buttonOption1 = findViewById(R.id.buttonOption1)
//        buttonOption2 = findViewById(R.id.buttonOption2)
//        buttonOption3 = findViewById(R.id.buttonOption3)
//        buttonOption4 = findViewById(R.id.buttonOption4)
//
//        val category = intent.getStringExtra("CATEGORY")
//        questionList = when (category) {
//            "european" -> QuizQuestions.getEuropeanQuestions()
//            "african" -> QuizQuestions.getAfricanQuestions()
//            "asian" -> QuizQuestions.getAsianQuestions()
//            else -> listOf()
//        }
//
//        showNextQuestion()
//    }
//
//    private fun showNextQuestion() {
//        if (currentQuestionIndex < questionList.size) {
//            val currentQuestion = questionList[currentQuestionIndex]
//            textViewQuestion.text = currentQuestion.question
//            val options = currentQuestion.options.shuffled()
//            buttonOption1.text = options[0]
//            buttonOption2.text = options[1]
//            buttonOption3.text = options[2]
//            buttonOption4.text = options[3]
//
//            buttonOption1.setOnClickListener { checkAnswer(options[0]) }
//            buttonOption2.setOnClickListener { checkAnswer(options[1]) }
//            buttonOption3.setOnClickListener { checkAnswer(options[2]) }
//            buttonOption4.setOnClickListener { checkAnswer(options[3]) }
//
//            startTimer()
//        } else {
//            endQuiz()
//        }
//    }
//
//    private fun startTimer() {
//        timer?.cancel()
//        timer = object : CountDownTimer(10000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                textViewTimer.text = "Time: ${millisUntilFinished / 1000}"
//            }
//
//            override fun onFinish() {
//                checkAnswer(null)
//            }
//        }.start()
//    }
//
//    private fun checkAnswer(selectedAnswer: String?) {
//        timer?.cancel()
//        val correctAnswer = questionList[currentQuestionIndex].answer
//        if (selectedAnswer == correctAnswer) {
//            correctAnswersCount++
//        }
//        currentQuestionIndex++
//        showNextQuestion()
//    }
//
//    private fun endQuiz() {
//        val intent = Intent(this, ScoreActivity::class.java)
//        intent.putExtra("SCORE", correctAnswersCount)
//        intent.putExtra("TOTAL_QUESTIONS", questionList.size)
//        startActivity(intent)
//        finish()
//    }
//}
//
package com.example.myquizapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myquizapp.data.Question
import com.example.myquizapp.data.QuizDatabase
import com.example.myquizapp.data.QuizQuestions
import com.example.myquizapp.data.Score
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuizActivity : AppCompatActivity() {

    private lateinit var textViewQuestion: TextView
    private lateinit var buttonOption1: Button
    private lateinit var buttonOption2: Button
    private lateinit var buttonOption3: Button
    private lateinit var buttonOption4: Button
    private lateinit var timerTextView: TextView

    private lateinit var questions: List<Question>
    private var currentQuestionIndex = 0
    private var score = 0
    private lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        textViewQuestion = findViewById(R.id.textViewQuestion)
        buttonOption1 = findViewById(R.id.buttonOption1)
        buttonOption2 = findViewById(R.id.buttonOption2)
        buttonOption3 = findViewById(R.id.buttonOption3)
        buttonOption4 = findViewById(R.id.buttonOption4)
        timerTextView = findViewById(R.id.timerTextView)

        val category = intent.getStringExtra("CATEGORY")
        val pseudo = intent.getStringExtra("PSEUDO") ?: "Anonyme"

        questions = when (category) {
            "EUROPEAN" -> QuizQuestions.getEuropeanQuestions()
            "AFRICAN" -> QuizQuestions.getAfricanQuestions()
            "ASIAN" -> QuizQuestions.getAsianQuestions()
            else -> emptyList()
        }

        if (questions.isNotEmpty()) {
            showNextQuestion()
        } else {
            endQuiz(pseudo)
        }
    }

    private fun showNextQuestion() {
        if (currentQuestionIndex < questions.size) {
            val question = questions[currentQuestionIndex]
            textViewQuestion.text = question.question
            val options = question.options.shuffled()
            buttonOption1.text = options[0]
            buttonOption2.text = options[1]
            buttonOption3.text = options[2]
            buttonOption4.text = options[3]

            buttonOption1.setOnClickListener { checkAnswer(options[0]) }
            buttonOption2.setOnClickListener { checkAnswer(options[1]) }
            buttonOption3.setOnClickListener { checkAnswer(options[2]) }
            buttonOption4.setOnClickListener { checkAnswer(options[3]) }

            startTimer()
        } else {
            endQuiz(intent.getStringExtra("PSEUDO") ?: "Anonyme")
        }
    }

    private fun checkAnswer(selectedOption: String) {
        val correctAnswer = questions[currentQuestionIndex].answer
        if (selectedOption == correctAnswer) {
            score++
        }
        currentQuestionIndex++
        countDownTimer.cancel()
        showNextQuestion()
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerTextView.text = "Temps restant : ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                currentQuestionIndex++
                showNextQuestion()
            }
        }.start()
    }

    private fun endQuiz(pseudo: String) {
        saveScore(pseudo)
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("SCORE", score)
        startActivity(intent)
    }

    private fun saveScore(pseudo: String) {
        val scoreEntity = Score(pseudo = pseudo, score = score)
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                QuizDatabase.getDatabase(applicationContext).scoreDao().insert(scoreEntity)
            }
        }
    }
}
