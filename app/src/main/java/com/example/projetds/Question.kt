package com.example.projetds

import android.os.Parcel
import android.os.Parcelable

class Question(var question:String, var chapitre:String, var choix1:String, var choix2:String, var choix3:String, var choix_correct:String):Parcelable{
    var selectedValue :String   = "Pas de réponse saisie"

    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!) {
        selectedValue = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeString(chapitre)
        parcel.writeString(choix1)
        parcel.writeString(choix2)
        parcel.writeString(choix3)
        parcel.writeString(choix_correct)
        parcel.writeString(selectedValue)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question {
            return Question(parcel)
        }

        override fun newArray(size: Int): Array<Question?> {
            return arrayOfNulls(size)
        }
    }

}