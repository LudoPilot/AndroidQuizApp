// CategorySelectionActivity.kt
//package com.example.myquizapp
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
//
//class CategorySelectionActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_category_selection)
//
//        val europeanCapitalsButton: Button = findViewById(R.id.europeanCapitalsButton)
//        val africanCapitalsButton: Button = findViewById(R.id.africanCapitalsButton)
//        val asianCapitalsButton: Button = findViewById(R.id.asianCapitalsButton)
//
//        europeanCapitalsButton.setOnClickListener {
//            startQuiz("european")
//        }
//
//        africanCapitalsButton.setOnClickListener {
//            startQuiz("african")
//        }
//
//        asianCapitalsButton.setOnClickListener {
//            startQuiz("asian")
//        }
//    }
//
//    private fun startQuiz(category: String) {
//        val intent = Intent(this, QuizActivity::class.java)
//        intent.putExtra("CATEGORY", category)
//        startActivity(intent)
//    }
//}

package com.example.myquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CategorySelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_selection)

        val pseudo = intent.getStringExtra("PSEUDO") ?: "Anonyme"

        val europeanCapitalsButton: Button = findViewById(R.id.europeanCapitalsButton)
        val africanCapitalsButton: Button = findViewById(R.id.africanCapitalsButton)
        val asianCapitalsButton: Button = findViewById(R.id.asianCapitalsButton)

        europeanCapitalsButton.setOnClickListener {
            startQuizActivity("EUROPEAN", pseudo)
        }

        africanCapitalsButton.setOnClickListener {
            startQuizActivity("AFRICAN", pseudo)
        }

        asianCapitalsButton.setOnClickListener {
            startQuizActivity("ASIAN", pseudo)
        }
    }

    private fun startQuizActivity(category: String, pseudo: String) {
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra("CATEGORY", category)
        intent.putExtra("PSEUDO", pseudo)
        startActivity(intent)
    }
}



