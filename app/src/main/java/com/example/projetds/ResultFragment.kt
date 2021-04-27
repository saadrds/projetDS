package com.example.projetds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment( var myscore: Int ) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var score = view?.findViewById<TextView>(R.id.finalScore)
        var image = view?.findViewById<ImageView>(R.id.imageView)

        if(myscore <= 5){
            if (myscore != null) {
                if (score != null) {
                    score.text = " You failed the exam :( , Votre score est :  " + myscore.toString()
                }
            }
            if (image != null) {
                image.setImageResource(R.drawable.failed)
            }
        }
        else{
            if (myscore != null) {
                if (score != null) {
                    score.text = " Congraaatss!! Votre score est :  " + myscore.toString()
                }
            }
            if (image != null) {
                image.setImageResource(R.drawable.pass)
            }

        }


    }

}