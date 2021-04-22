package com.example.projetds

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuesAdapter(val context: Context, val list : ArrayList <Question>): RecyclerView.Adapter<QuesAdapter.FilleHolder>() {
    lateinit var myActivity:ItemCliked
    init {
        myActivity = context as ItemCliked
    }
        inner class FilleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) // inner classe filleHolder qui herite de RecyclerView.ViewHolder
        {
            val text1 : TextView = itemView.findViewById<TextView>(R.id.quest) // récupération du text view spécifié pour le mot
            val text2 : TextView = itemView.findViewById<TextView>(R.id.rep) // récupération du text view spécifié pour la définition
            init {
                // Ensuite pour chaque ligne dans splited, on dévise chaque case pour séparer chaque mot de sa définition et cela par ":"
                itemView.setOnClickListener { view -> myActivity.onItemClicked(list.indexOf(view.tag as Question))  }
            }

        }

        interface ItemCliked
        {
            fun onItemClicked(index:Int)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilleHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.check_item,parent,false)
            return FilleHolder(itemView)
        }

        override fun onBindViewHolder(holder: FilleHolder, position: Int) {
            val currentDesc = list[position]
            holder.text1.text = currentDesc.question
            holder.text2.text = currentDesc.selectedValue
            holder.itemView.tag = list[position]
            // holder.text2.setMovementMethod(ScrollingMovementMethod())
        }

        override fun getItemCount(): Int {
            return list.size
        }

    }
