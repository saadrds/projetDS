package com.example.projetds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.projetds.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var i = 0
    val array = ArrayList<Question>()
    val arrayFragments = ArrayList<QuestionFragment>()
    val manager = supportFragmentManager// Pour API >=19



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val vieww = binding.root
        //setContentView(vieww)
        setContentView(R.layout.activity_main)


       val q1 = Question("Quelle la somme de 1 + 1 ?","Mathematiques","3","29","1","1")
        val q2 = Question("Quel le produit  de 3 * 4 ?","Mathematiques","12","59","4","12")
        val q3 = Question("le factoriel de 3? ","Mathematiques","124","0","6","6")
        val q4 = Question("Quelle le somme  de 10 + 4 ?","Mathematiques","14","69","9","14")
        array.add(q1)
        array.add(q2)
        array.add(q3)
        array.add(q4)
        for(j in 0..3){//initializing an array of fragments and then adding them to the frame and then hiding them all
            arrayFragments.add(QuestionFragment(array[j],j+1))

            val trans = manager.beginTransaction()
            trans.add(R.id.frameFrag, arrayFragments[j])
            trans.hide(arrayFragments[j])
            trans.commit()
        }
        //after that we show the 1st fragment while others are hidden
        val trans = manager.beginTransaction()
         trans.show(arrayFragments[0])
        trans.commit()
        manageButtons()

    }


    fun nextFunction(view: View) {
// transaction

// mettre les fragments
        if(i < array.count() -1){//hiding the previous fragment and showing the new one
            i++
            val trans = manager.beginTransaction()
            if(i != 0){
                trans.hide(arrayFragments[i-1])
            }
            trans.show(arrayFragments[i])
            trans.commit();

            manageButtons()
        }
    }

    fun previous(view: View) {//click on button previous
// transaction

// mettre les fragments
        // val textT = findViewById<TextView>(R.id.textView5).text.toString()

        if(i > 0){//hiding the frag 'i' and showing the previous one i-1

            val trans = manager.beginTransaction()
            trans.hide(arrayFragments[i])
            trans.show(arrayFragments[i-1])
            i--

            trans.commit();

           manageButtons()
        }
    }

    fun manageButtons(){//function that show and hide previous and next buttons depends on which question is showed
        val nextButton = findViewById<Button>(R.id.next)
        val previousButton = findViewById<Button>(R.id.previous)
        if(i == 0){//if i = 0 previous shouldnt be shown
            previousButton.setVisibility(View.GONE)
        }
        else if(i == array.count() -1){//if i = 9 next shouldnt be shown
            nextButton.setVisibility(View.GONE)
        }
        else{
            if(nextButton.visibility == View.GONE)
                nextButton.setVisibility(View.VISIBLE)
            if(previousButton.visibility == View.GONE)
                previousButton.setVisibility(View.VISIBLE)
        }
    }
}