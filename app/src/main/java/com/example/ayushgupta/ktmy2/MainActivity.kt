package com.example.ayushgupta.ktmy2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        btn1.setOnClickListener {
            val intent = Intent(this,SpinnerTest::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener {
            val intent = Intent(this,ListTest::class.java)
            startActivity(intent)
        }
    }
}
