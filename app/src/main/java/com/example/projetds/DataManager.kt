package com.example.projetds

import android.content.ContentValues
import android.content.Context

class DataManager(val context: Context) {


    val helper = myDBHelper(context)

    fun fillData(){
        val db = helper.readableDatabase
        val cursor = db.query(DBContract.Question.TABLE_NAME, null, null, null, null, null, null)
        if (cursor.count == 0){
            add("aChaque a", "Intent", "AndroidManifest.xml", "Gradle", "MainActivity","AndroidManifest.xml")
            add("bChaque activité a une entrée dans le fichier : ?", "Intent", "AndroidManifest.xml", "Gradle", "MainActivity","AndroidManifest.xml")
            add("cChaque activité a une entrée dans le fichier : ?", "Intent", "AndroidManifest.xml", "Gradle", "MainActivity","AndroidManifest.xml")
            add("dChaque activité a une entrée dans le fichier : ?", "Intent", "AndroidManifest.xml", "Gradle", "MainActivity","AndroidManifest.xml")
        }
    }
    fun add(question: String, chapitre: String, choix1: String, choix2: String, choix3: String, choix_correct: String) {
        val dataBase = helper.writableDatabase
        val values = ContentValues()
        values.put(DBContract.Question.QUESTION, question)
        values.put(DBContract.Question.CHAPITRE, chapitre)
        values.put(DBContract.Question.CHOIX1, choix1)
        values.put(DBContract.Question.CHOIX2, choix2)
        values.put(DBContract.Question.CHOIX3, choix3)
        values.put(DBContract.Question.CHOIX_CORRECT, choix_correct)

        val rowAffected = dataBase?.insert(DBContract.Question.TABLE_NAME, null, values)
    }

    /*
    fun delete(nom: String) {
        val dataBase = helper.writableDatabase
        val selection = "${DBContract.Question.NOM} = ?"
        val selectionArgs = arrayOf("$nom")
        val deleteRows = dataBase.delete(DBContract.Question.TABLE_NAME, selection, selectionArgs)
    }
    */
    fun getAllItems(): ArrayList<Question> {
        val result = ArrayList<Question>()
        val dataBase = helper.readableDatabase

        val cursor = dataBase?.query(DBContract.Question.TABLE_NAME, null, null, null, null, null, null)
        while (cursor?.moveToNext()!!) {
            //val id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
            val question = cursor.getString(cursor.getColumnIndex(DBContract.Question.QUESTION))
            val chapitre = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHAPITRE))
            val choix1 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX1))
            val choix2 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX2))
            val choix3 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX3))
            val choix_correct = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX_CORRECT))
            result.add(Question(question, chapitre, choix1, choix2, choix3, choix_correct))
        }
        return result
    }

    fun getTenRandom(chapitre: String):ArrayList<Question>{
        val selection = "${DBContract.Question.CHAPITRE} = ?"
        val selectionArgs = arrayOf(chapitre)
        val result = ArrayList<Question>()
        val dataBase = helper.readableDatabase
        val cursor = dataBase?.query(DBContract.Question.TABLE_NAME, null, selection, selectionArgs, null, null, "RANDOM() limit 10")
        while (cursor?.moveToNext()!!) {
            //val id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
            val question = cursor.getString(cursor.getColumnIndex(DBContract.Question.QUESTION))
            val choix1 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX1))
            val choix2 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX2))
            val choix3 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX3))
            val choix_correct = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX_CORRECT))
            result.add(Question(question, chapitre, choix1, choix2, choix3, choix_correct))
        }
        return result

    }
    /*
    fun update(nom: String, prenom: String, imagePath : String) {
        val dataBase = helper.writableDatabase
        val selection = "${DBContract.Question.NOM} = ?"
        val selectionArgs = arrayOf("$NOM")
        val values = ContentValues()
        values.put(DBContract.Question.NOM, nom)
        values.put(DBContract.Question.PRENOM, prenom)
        values.put(DBContract.Question.IMAGEPATH, imagePath)
        val nbRowsUpdated = dataBase.update(DBContract.Question.TABLE_NAME, values, selection, selectionArgs)
    }
*/
    fun close() {
        helper.close();
    }
}