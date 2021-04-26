package com.example.projetds

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var myscore = findViewById<TextView>(R.id.finalScore)
        var image = findViewById<ImageView>(R.id.imageView)
        val manager = supportFragmentManager
        val b2 = intent.extras
        val myArrayQuestions = b2?.getParcelableArrayList<Question>("questionsArray")
        if (b2 != null) {
           var myFinalscore =  b2.getInt("score")
            if(myFinalscore <= 5){
            myscore.text = " You failed the exam :( , Votre score est :  " + myFinalscore.toString()
                image.setImageResource(R.drawable.failed)
        }
            else{
                myscore.text = " Congraaatss!! Votre score est :  " + myFinalscore.toString()
                image.setImageResource(R.drawable.pass)

            }

        }
        val frag1 = recapList(myArrayQuestions!!)
        findViewById<Button>(R.id.showRecap).setOnClickListener {

            val trans = manager.beginTransaction()
            trans.add(R.id.recapFrame,frag1)
            trans.commit()
        }
    }
}