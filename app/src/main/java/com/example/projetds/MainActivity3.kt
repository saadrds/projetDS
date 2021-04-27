package com.example.projetds

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val manager = supportFragmentManager
        lateinit var frag: ResultFragment
        val b2 = intent.extras
        var myFinalscore:Int
        val myArrayQuestions = b2?.getParcelableArrayList<Question>("questionsArray")
        if (b2 != null) {
           myFinalscore =  b2.getInt("score")
            frag = ResultFragment(myFinalscore)
            val trans = manager.beginTransaction()
            trans.add(R.id.recapFrame,frag)
            trans.commit()
        }
        val frag1 = recapList(myArrayQuestions!!)
        findViewById<Button>(R.id.showRecap).setOnClickListener {

            val trans = manager.beginTransaction()
            trans.hide(frag)
            trans.add(R.id.recapFrame,frag1)
            trans.commit()
        }
    }
}