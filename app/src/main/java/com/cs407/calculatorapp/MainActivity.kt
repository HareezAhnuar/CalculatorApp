package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editText1 = findViewById<EditText>(R.id.editTextText)
        val editText2 = findViewById<EditText>(R.id.editTextText2)
        val addButton = findViewById<Button>(R.id.button_add)
        val subButton = findViewById<Button>(R.id.button_sub)
        val multButton = findViewById<Button>(R.id.button_mult)
        val divButton = findViewById<Button>(R.id.button_div)

        addButton.setOnClickListener {
            val userInput1 = editText1.text.toString()
            val userInput2 = editText2.text.toString()

            // Convert inputs to integers, and handle invalid input
            val value1 = userInput1.toIntOrNull() ?: 0
            val value2 = userInput2.toIntOrNull() ?: 0

            val result = (value1 + value2).toString()
            // Create an intent to navigate to CalculatorActivity
            val intent = Intent(this, ResultActivity::class.java)
            // Pass the user input to the new activity
            intent.putExtra("EXTRA_MESSAGE", result)
            // Start the new activity
            startActivity(intent)
        }

        subButton.setOnClickListener {
            val userInput1 = editText1.text.toString()
            val userInput2 = editText2.text.toString()

            // Convert inputs to integers, and handle invalid input
            val value1 = userInput1.toIntOrNull() ?: 0
            val value2 = userInput2.toIntOrNull() ?: 0

            val result = (value1 - value2).toString()
            // Create an intent to navigate to CalculatorActivity
            val intent = Intent(this, ResultActivity::class.java)
            // Pass the user input to the new activity
            intent.putExtra("EXTRA_MESSAGE", result)
            // Start the new activity
            startActivity(intent)
        }

        multButton.setOnClickListener {
            val userInput1 = editText1.text.toString()
            val userInput2 = editText2.text.toString()

            // Convert inputs to integers, and handle invalid input
            val value1 = userInput1.toIntOrNull() ?: 0
            val value2 = userInput2.toIntOrNull() ?: 0
            val result = (value1 * value2).toString()
            // Create an intent to navigate to CalculatorActivity
            val intent = Intent(this, ResultActivity::class.java)
            // Pass the user input to the new activity
            intent.putExtra("EXTRA_MESSAGE", result)
            // Start the new activity
            startActivity(intent)
        }

        divButton.setOnClickListener {
            val userInput1 = editText1.text.toString()
            val userInput2 = editText2.text.toString()

            // Convert inputs to integers, and handle invalid input
            val value1 = userInput1.toFloatOrNull()
            val value2 = userInput2.toFloatOrNull()

            // Check if either input is null (invalid) or if value2 is zero
            if (value1 == null || value2 == null) {
                // Display error message if inputs are not valid integers
                Toast.makeText(this, "Please enter valid integers.", Toast.LENGTH_SHORT).show()
            } else if (value2 == 0f) {
                // Handle divide-by-zero case
                Toast.makeText(this, "Error: Division by zero is not allowed.", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // Perform the division since inputs are valid and value2 is not zero
                val result = (value1 / value2).toString()
                // Create an intent to navigate to CalculatorActivity
                val intent = Intent(this, ResultActivity::class.java)
                // Pass the user input to the new activity
                intent.putExtra("EXTRA_MESSAGE", result)
                // Start the new activity
                startActivity(intent)
            }

        }
    }
}