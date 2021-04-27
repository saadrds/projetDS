package com.example.projetds

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity3 : AppCompatActivity() {
    lateinit var frag: ResultFragment
    lateinit var frag1: recapList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var showScore = findViewById<Button>(R.id.showFinalScore)
        var showRecap =  findViewById<Button>(R.id.showRecap)

        showScore.visibility = View.GONE
        val manager = supportFragmentManager
        val b2 = intent.extras
        val myArrayQuestions = b2?.getParcelableArrayList<Question>("questionsArray")
        val myFinalscore =  b2!!.getInt("score")
        frag = ResultFragment(myFinalscore)
        frag1 = recapList(myArrayQuestions!!)
        val trans = manager.beginTransaction()
        trans.add(R.id.recapFrame,frag1)
        trans.hide(frag1)
        trans.add(R.id.recapFrame,frag)
        trans.commit()
       showRecap.setOnClickListener {

            val trans = manager.beginTransaction()
            trans.hide(frag)
            trans.show(frag1)
            trans.commit()
           showRecap.visibility = View.GONE
           showScore.visibility= View.VISIBLE

        }
        showScore.setOnClickListener {

            val trans = manager.beginTransaction()
            trans.hide(frag1)
            trans.show(frag)
            trans.commit()
            showRecap.visibility = View.VISIBLE
            showScore.visibility= View.GONE
        }
    }
}