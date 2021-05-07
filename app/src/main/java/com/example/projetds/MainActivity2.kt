package com.example.projetds

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intentButton = findViewById<Button>(R.id.Intent)
        val stockageButton = findViewById<Button>(R.id.stockage)
        val FragmentsButton = findViewById<Button>(R.id.FragmentsButton)


        intentButton.setOnClickListener {

            val mp = MediaPlayer.create(this, R.raw.b_click)
            mp.start()
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("chapter","Intent")
            startActivity(intent)
        }

        stockageButton.setOnClickListener {
            val mp = MediaPlayer.create(this, R.raw.b_click)
            mp.start()
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("chapter","Stockage et Sqlite")
            startActivity(intent)
        }

        FragmentsButton.setOnClickListener {
            //val mp = MediaPlayer.create(this, R.raw.b3_click)
            //mp.start()
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("chapter","Fragments")
            startActivity(intent)
        }
    }
}