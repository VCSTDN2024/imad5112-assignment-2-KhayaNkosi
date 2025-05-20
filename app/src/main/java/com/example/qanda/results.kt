package com.example.qanda

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class results : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results)

        // Initialize UI elements
        val ResultTxt = findViewById<TextView>(R.id.ResultTxt)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnClose = findViewById<Button>(R.id.btnClose)
        val btnNextPage = findViewById<Button>(R.id.btnNextPage)

        // Get the result from the intent that's on the exp activity
        val askedquestion = intent.getStringArrayExtra("questions")
        val answerstoquestions = intent.getBooleanArrayExtra("answers")

        // Display the results
        val resultTxt = StringBuilder()
        if (askedquestion != null && answerstoquestions !=null  && askedquestion.size == answerstoquestions.size) {
            for (i in askedquestion.indices) {
                resultTxt.append("${i + 1}. ${askedquestion[i]}\n")
                resultTxt.append("Answer: ${if (answerstoquestions[i]) "True" else "False"}\n\n")
            }
            ResultTxt.text = resultTxt.toString()
        }else {
            ResultTxt.text = "No results to display."

        }
        // Set click listeners for buttons to move to the next activity
        btnNextPage.setOnClickListener(
            {
                val intent = intent.setClass(this, end::class.java)
                finish()
                startActivity(intent)
            }
        )
        // Set a click listener for the "Reset" button to restart the app
        btnReset.setOnClickListener {
            val intent = intent.setClass(this, MainActivity::class.java)
            finish()
            startActivity(intent)
        }
        // Set a click listener for the "Exit" button to exit the app
        btnClose.setOnClickListener {
            finishAffinity()
            exitProcess(0)

            }

        }




}