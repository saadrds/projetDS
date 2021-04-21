package com.example.projetds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intentButton = findViewById<Button>(R.id.Intent)
        val stockageButton = findViewById<Button>(R.id.stockage)

        intentButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("chapter","Intent")
            startActivity(intent)
        }

        stockageButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("chapter","Stockage et Sqlite")
            startActivity(intent)
        }
    }
}