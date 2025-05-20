package com.example.qanda

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.ProcessBuilder.Redirect

class exp : AppCompatActivity() {

    // Declare UI elements
    private lateinit var QuestionTxtView: TextView
    private lateinit var AnswerTxtView : TextView
    private lateinit var btnTrue : Button
    private lateinit var btnFalse : Button
    private lateinit var btnNext: Button

    // Define arrays for questions and answers to store the questions and answers
    companion object{
        val askedquestion = arrayOf(
            "The Planet Earth is flat",
            "The Stars in the sky are luminous balls of gas held together by its own gravity",
            "In our Solar system there are seven planets",
            "Dark force is a mysterious force that is causing the universe to expand ",
            "Pluto is not a planet in our Solar system"
        )
        val answerstoquestions = booleanArrayOf(false, true, false, true, true)
    }
        // Initialize variables to keep track of the current question and result
        private var typeofquestionsdisplayed = 0
        private var result = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_exp)

        // Initialize UI elements
        QuestionTxtView = findViewById(R.id.QuestionTxtView)
        AnswerTxtView = findViewById(R.id.AnswerTxtView)
        btnNext = findViewById(R.id.btnNext)
        btnFalse = findViewById(R.id.btnFalse)
        btnTrue = findViewById(R.id.btnTrue)
        // Display the first question
        displayquestion()

        // Set click listeners for buttons to check the answer and move to the next question
        btnTrue.setOnClickListener { checkAnswer(true) }
        btnFalse.setOnClickListener { checkAnswer(false) }

        // Set a click listener for the "Next" button to move to the next question
        btnNext.setOnClickListener {
            typeofquestionsdisplayed++
            if (typeofquestionsdisplayed < askedquestion.size) {
                displayquestion()
                AnswerTxtView.text = ""
                btnTrue.isEnabled = true
                btnFalse.isEnabled = true
            } else {
                val intent = Intent(this, results::class.java)
                intent.putExtra("result", result)
                startActivity(intent)
                finish()
            }
        }
        btnNext.isEnabled = false

    }
   // Display the current question
    private fun displayquestion() {
        QuestionTxtView.text = askedquestion[typeofquestionsdisplayed]
    }
    // Check the user's answer and update the UI accordingly
    private fun checkAnswer(userAnswer:Boolean) {
        val correctAnswer = answerstoquestions[typeofquestionsdisplayed]
        // Check if the user's answer is correct and update the UI accordingly
        if (userAnswer == correctAnswer) {
            AnswerTxtView.text = "You are 100% coorect!"
            AnswerTxtView.setTextColor(Color.CYAN)
            result++
        } else {
            AnswerTxtView.text = " Unfortunately you are incorrect"
            AnswerTxtView.setTextColor(Color.YELLOW)
        }
        btnTrue.isEnabled = false
        btnFalse.isEnabled = false
        btnNext.isEnabled = true
    }
}







