package com.example.projetds

import android.view.View

interface Communicator {
    fun getScore():Int
    fun setScore()
    fun setAnswer(valeur:Int)
    //fun fillDatabase()

}