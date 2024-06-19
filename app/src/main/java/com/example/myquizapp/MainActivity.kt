//package com.example.myquizapp
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val editTextPseudo = findViewById<EditText>(R.id.editTextPseudo)
//        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
//
//        buttonLogin.setOnClickListener {
//            val pseudo = editTextPseudo.text.toString()
//            if (pseudo.isNotEmpty()) {
//                val intent = Intent(this, CategorySelectionActivity::class.java)
//                intent.putExtra("PSEUDO", pseudo)
//                startActivity(intent)
//            } else {
//                Toast.makeText(this, "Veuillez entrer un pseudo", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}
package com.example.myquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextPseudo: EditText = findViewById(R.id.editTextPseudo)
        val buttonLogin: Button = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val pseudo = editTextPseudo.text.toString().trim()
            val intent = Intent(this, CategorySelectionActivity::class.java)
            intent.putExtra("PSEUDO", pseudo)
            startActivity(intent)
        }
    }
}
