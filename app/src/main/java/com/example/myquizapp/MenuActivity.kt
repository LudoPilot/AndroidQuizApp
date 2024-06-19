package com.example.myquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val buttonEurope: Button = findViewById(R.id.buttonEurope)
        val buttonAfrique: Button = findViewById(R.id.buttonAfrique)
        val buttonAsie: Button = findViewById(R.id.buttonAsie)

        buttonEurope.setOnClickListener { startQuiz("Europe") }
        buttonAfrique.setOnClickListener { startQuiz("Afrique") }
        buttonAsie.setOnClickListener { startQuiz("Asie") }
    }

    private fun startQuiz(category: String) {
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra("CATEGORY", category)
        startActivity(intent)
    }
}
