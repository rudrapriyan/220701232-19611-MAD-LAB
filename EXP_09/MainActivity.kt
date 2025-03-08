package com.example.alertdialogbox

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val inText: EditText = findViewById(R.id.inText)
        val btDisplay: Button = findViewById(R.id.button)

        btDisplay.setOnClickListener {
            val alertDialogBox = AlertDialog.Builder(this).setTitle("Alert Dialog Box")
                .setMessage(inText.text.toString()).setPositiveButton("OK") { dialog, which ->
                Toast.makeText(this, "You have clicked Ok", Toast.LENGTH_LONG).show()
            }.setNegativeButton("Cancel") { dialog, which ->
                Toast.makeText(this, "You have clicked Cancel", Toast.LENGTH_LONG).show()
            }
            alertDialogBox.show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}