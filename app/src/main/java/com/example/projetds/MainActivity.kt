package com.example.projetds

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class
MainActivity : AppCompatActivity(),Communicator,QuesAdapter.ItemCliked {
    lateinit var radioClick : RadioClick
    lateinit var scoreClick: ScoreClick
    var Totalscore = 0;
    var i = 0
    var array = ArrayList<Question>() // tableau des questions
    val arrayFragments = ArrayList<QuestionFragment>() // tableau des fragements
    val manager = supportFragmentManager// Pour API >=19
    var answersTab = ArrayList<Int>()
    lateinit var answersFrag:Fragment
    lateinit var submitButton:Button
    lateinit var resButton: Button
    val currentAc = this
    var total = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val vieww = binding.root
        //setContentView(vieww)
        setContentView(R.layout.activity_main)
        submitButton = findViewById<Button>(R.id.submit)
        resButton = findViewById<Button>(R.id.resultat)

        resButton.setVisibility(View.GONE)

        val intent = intent
        val chapter = intent.getStringExtra("chapter")!!



        val myManager = DataManager(this)
        myManager.fillData()
        myManager.close()
        val my2Manager = DataManager(this)
        array = my2Manager.getTenRandom(chapter)
        my2Manager.close()
        /*val Dmanager = DataManager(this)
        array = Dmanager.getAllItems()

        Dmanager.close()*/
        for(j in 0..array.count()-1){//initializing an array of fragments and then adding them to the frame and then hiding them all
            arrayFragments.add(QuestionFragment(array[j], j + 1))
            answersTab.add(0)

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


        submitButton.setOnClickListener {
            val mp = MediaPlayer.create(this, R.raw.b_click)
            mp.start()
            val nextButton = findViewById<Button>(R.id.next)
            val previousButton = findViewById<Button>(R.id.previous)
            resButton.setVisibility(View.VISIBLE)

            previousButton.setVisibility(View.GONE)
            nextButton.setVisibility(View.GONE)
            submitButton.setVisibility(View.GONE)
             total = 0
            for (k in 0..array.count()-1){
                total += answersTab[k]
            }
           // findViewById<TextView>(R.id.score).text = total.toString()

            for(j in 0..array.count()-1){
                val trans = manager.beginTransaction()
                trans.hide(arrayFragments[j])
                trans.commit();
            }


            val trans = manager.beginTransaction()
            answersFrag = answers(array)
            trans.add(R.id.frameFrag, answersFrag)
            trans.commit()

        }
        resButton.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            val b1 = Bundle()
            b1.putInt("score", total)
            b1.putParcelableArrayList("questionsArray",array)
            intent.putExtras(b1)
            startActivity(intent)
        }
    }


    fun nextFunction(view: View) {
// transaction

// mettre les fragments

        val mp = MediaPlayer.create(this, R.raw.b3_click)
        mp.start()
        if(i < array.count() -1){//hiding the previous fragment and showing the new one
            i++
            val trans = manager.beginTransaction()
            if(i != 0){
                trans.hide(arrayFragments[i - 1])
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
        val mp = MediaPlayer.create(this, R.raw.b3_click)
        mp.start()
        if(i > 0){//hiding the frag 'i' and showing the previous one i-1

            val trans = manager.beginTransaction()
            trans.hide(arrayFragments[i])
            trans.show(arrayFragments[i - 1])
            i--

            trans.commit();

           manageButtons()
        }
    }



    fun manageButtons(){//function that show and hide previous and next buttons depends on which question is showed
        val nextButton = findViewById<Button>(R.id.next)
        val previousButton = findViewById<Button>(R.id.previous)
        val resultat = findViewById<Button>(R.id.resultat)
        resultat.setVisibility(View.GONE)

        if(i == 0){//if i = 0 previous shouldnt be shown
            nextButton.setVisibility(View.VISIBLE)
            previousButton.setVisibility(View.GONE)
            submitButton.setVisibility(View.GONE)
        }
        else if(i == array.count() -1){//if i = 9 next shouldnt be shown
            nextButton.setVisibility(View.GONE)
            submitButton.setVisibility(View.VISIBLE)

        }
        else{
            if(nextButton.visibility == View.GONE)
                nextButton.setVisibility(View.VISIBLE)
            if(previousButton.visibility == View.GONE)
                previousButton.setVisibility(View.VISIBLE)
            submitButton.setVisibility(View.GONE)
        }
    }

    fun btn_click(view: View) {
        radioClick = arrayFragments[i] as RadioClick
        radioClick.myClickMethod(view)
    }


    override fun getScore(): Int {
        return Totalscore
    }


    override fun setScore() {
        Totalscore++
    }

    override fun setAnswer(valeur: Int) {
        answersTab[i] = valeur
    }

    override fun setAnswerChoice(answer: String) {
        array[i].selectedValue = answer
    }

    override fun onItemClicked(index: Int) {

        i = index
        val trans = manager.beginTransaction()
        trans.hide(answersFrag)
        trans.show(arrayFragments[i])
        trans.commit();
        manageButtons()


    }



}