package com.example.projetds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        manager.findFragmentById(R.id.fragmentQuestions)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentAnswers)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentChapters)?.let { transaction.show(it) }
        manager.findFragmentById(R.id.fragmentScore)?.let { transaction.hide(it) }
        transaction.commit()
    }

    fun ClickChapitre1(view: View){
        val manager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        manager.findFragmentById(R.id.fragmentQuestions)?.let { transaction.show(it) }
        manager.findFragmentById(R.id.fragmentAnswers)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentChapters)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentScore)?.let { transaction.hide(it) }
        transaction.commit()

    }

    fun ClickChapitre2(view: View){
        val manager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        manager.findFragmentById(R.id.fragmentQuestions)?.let { transaction.show(it) }
        manager.findFragmentById(R.id.fragmentAnswers)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentChapters)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentScore)?.let { transaction.hide(it) }
        transaction.commit()

    }

    fun ClickChapitre3(view: View){
        val manager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        manager.findFragmentById(R.id.fragmentQuestions)?.let { transaction.show(it) }
        manager.findFragmentById(R.id.fragmentAnswers)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentChapters)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentScore)?.let { transaction.hide(it) }
        transaction.commit()

    }

    fun ClickChapitre4(view: View){
        val manager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        manager.findFragmentById(R.id.fragmentQuestions)?.let { transaction.show(it) }
        manager.findFragmentById(R.id.fragmentAnswers)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentChapters)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentScore)?.let { transaction.hide(it) }
        transaction.commit()

    }
    // Button questions fragement
    fun TestFinished(view: View){
        val manager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        manager.findFragmentById(R.id.fragmentQuestions)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentAnswers)?.let { transaction.show(it) }
        manager.findFragmentById(R.id.fragmentChapters)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentScore)?.let { transaction.hide(it) }
        transaction.commit()

    }

    // Button answers fragement
    fun PrintResults(view: View){
        val manager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        manager.findFragmentById(R.id.fragmentQuestions)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentAnswers)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentChapters)?.let { transaction.hide(it) }
        manager.findFragmentById(R.id.fragmentScore)?.let { transaction.show(it) }
        transaction.commit()

    }




}