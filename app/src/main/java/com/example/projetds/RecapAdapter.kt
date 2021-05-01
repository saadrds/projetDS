package com.example.projetds

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecapAdapter(val context: Context, val list : ArrayList <Question>): RecyclerView.Adapter<RecapAdapter.FilleHolder>() {

    inner class FilleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) // inner classe filleHolder qui herite de RecyclerView.ViewHolder
    {
        val text1 : TextView = itemView.findViewById<TextView>(R.id.Recap) // récupération du text view spécifié pour la question
        val recap1 : TextView = itemView.findViewById<TextView>(R.id.recap1) // récupération du text view spécifié pour le choix1
        val recap2 : TextView = itemView.findViewById<TextView>(R.id.recap2) // récupération du text view spécifié pour le choix2
        val recap3 : TextView = itemView.findViewById<TextView>(R.id.recap3) // récupération du text view spécifié pour le choix3
        val selectedRecap : TextView = itemView.findViewById<TextView>(R.id.selectedRecap) // récupération du text view spécifié pour le choix3


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilleHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recap_item,parent,false)
        return FilleHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilleHolder, position: Int) {
        val currentDesc = list[position]
        holder.text1.text = (position + 1).toString() + ". " + currentDesc.question
        holder.recap1.text = currentDesc.choix1
        holder.recap2.text = currentDesc.choix2
        holder.recap3.text = currentDesc.choix3
        holder.selectedRecap.text = currentDesc.selectedValue

        if(currentDesc.choix1 == currentDesc.choix_correct){
            holder.recap1.setTextColor(Color.GREEN)
        }
        if(currentDesc.choix2 == currentDesc.choix_correct){
            holder.recap2.setTextColor(Color.GREEN)
        }
        if(currentDesc.choix3 == currentDesc.choix_correct){
            holder.recap3.setTextColor(Color.GREEN)
        }

        if(currentDesc.selectedValue == currentDesc.choix_correct){
            holder.selectedRecap.setBackgroundColor(Color.GREEN)
        }
        else{
            holder.selectedRecap.setBackgroundColor(Color.RED)
        }
        holder.itemView.tag = list[position]
        // holder.text2.setMovementMethod(ScrollingMovementMethod())
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
