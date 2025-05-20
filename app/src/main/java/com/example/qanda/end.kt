package com.example.qanda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class end : AppCompatActivity() {

    // Private lateinit variables use to declare UI elements
    private lateinit var endTxtView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var btnresult: Button
    private lateinit var btnExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_end)

        // This is used to initialize UI elements
        endTxtView = findViewById(R.id.endTxtView)
        feedbackTextView = findViewById(R.id.feedbackTextView)
        btnresult = findViewById(R.id.btnresult)
        btnExit = findViewById(R.id.btnExit)

        // Get the result from the intent that's on the results activity
        val end = intent.getIntExtra("result", 0)
        endTxtView.text = "Your score: $end/5"

        // Set the feedback text based on the result
        val feedback = if (end >= 3) {
            "Congratulations! You did great!"
        }else{
            "Keep going at it! You can do it!"
        }
        feedbackTextView.text = feedback

        // Set click listeners for buttons to move to the past activity so that the user can restart the app
        btnresult.setOnClickListener {
            val intent = Intent(this, results::class.java)
            startActivity(intent)
        }
        // Set a click listener for the "Exit" button to exit the app
        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}