package com.example.qanda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.exp
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        val btnBegin = findViewById<Button>(R.id.btnBegin)
        val btnExit = findViewById<Button>(R.id.btnExit)

        // Set click listeners for buttons so the buttons can function
        btnBegin.setOnClickListener{
            startActivity(Intent(this,exp::class.java))
        }
        // Set a click listener for the "Exit" button to exit the app
        btnExit.setOnClickListener{
            finishActivity(1)
            exitProcess(0)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}