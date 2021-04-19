package com.example.projetds

import android.provider.BaseColumns

object DBContract {
    object Question : BaseColumns {
        const val TABLE_NAME = "Question"
        const val QUESTION = "question"
        const val CHAPITRE = "chappitre"
        const val CHOIX1 = "choix1"
        const val CHOIX2 = "choix2"
        const val CHOIX3 = "choix3"
        const val CHOIX_CORRECT = "choix_correct"

        const val SQL_CREATE_TABLE = "CREATE TABLE $TABLE_NAME($QUESTION TEXT, $CHAPITRE TEXT, $CHOIX1 TEXT, $CHOIX2 TEXT, $CHOIX2 TEXT, $CHOIX_CORRECT TEXT)"
        const val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}