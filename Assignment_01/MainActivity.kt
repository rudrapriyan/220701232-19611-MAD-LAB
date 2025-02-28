package com.example.assignment_01

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        val etEmailId : EditText = findViewById(R.id.etEmailId)
        val etPassWord : EditText = findViewById(R.id.etPassWord)
        val btValidate: Button = findViewById(R.id.btValidate)
        btValidate.setOnClickListener {
            val emailid = etEmailId.text.toString().trim()
            val password= etPassWord.text.toString().trim()
            if(emailid.isEmpty() || password.isEmpty())
            {
                Toast.makeText(this,"Fill all the fields.",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(!emailid.matches(Regex("^[a-zA-Z0-9]+@rajalakshmi\\.edu\\.in\$\n"))){
                Toast.makeText(this,"Invalid Username",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(!password.matches(Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}\$\n"))){
                Toast.makeText(this,"Invalid PIN",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val intent: Intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        }
    }
