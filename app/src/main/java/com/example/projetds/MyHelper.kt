package com.example.projetds

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.projetds.DBContract.Question.SQL_CREATE_TABLE
import com.example.projetds.DBContract.Question.SQL_DROP_TABLE

class myDBHelper(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    //lateinit var activity : Communicator
    //val myContext = context
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE)
        //activity = myContext as Communicator
        //activity.fillDatabase()

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DROP_TABLE)
        onCreate(db)
    }

    companion object{
        const val DATABASE_NAME  = "Question.db"
        const val DATABASE_VERSION = 1
    }
}