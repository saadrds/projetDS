package com.example.projetds

import android.content.Context
import android.view.View

interface Communicator {
    fun getScore():Int
    fun setScore()
    fun setAnswer(valeur:Int)
    fun setAnswerChoice(answer : String)



}