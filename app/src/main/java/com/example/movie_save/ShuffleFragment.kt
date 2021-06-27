package com.example.movie_save

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShuffleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class ShuffleFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_shuffle, container, false)

        val btn_random = view.findViewById<Button>(R.id.btn_random)

        btn_random.setOnClickListener{
            val idImg: Long = (1L..5L).random()
            val bundle = Bundle()
            bundle.putLong("idImg", idImg)
            when (idImg){
                1L ->{
                    bundle.putString("name", "The Shape of Water (2017)")
                    bundle.putFloat("score", 7.3f)
                    bundle.putString("brief", "At a top secret research facility in the 1960s, a lonely janitor forms a unique relationship with an amphibious creature that is being held in captivity.")
                }
                2L -> {
                    bundle.putString("name", "Lucy (2014)")
                    bundle.putFloat("score", 6.4f)
                    bundle.putString("brief", "A woman, accidentally caught in a dark deal, turns the tables on her captors and transforms into a merciless warrior evolved beyond human logic")
                }
                3L -> {
                    bundle.putString("name", "The Godfather (1972)")
                    bundle.putFloat("score", 9.2f)
                    bundle.putString("brief","An organized crime dynasty's aging patriarch transfers control of his clandestine empire to his reluctant son.")
                }
                4L -> {
                    bundle.putString("name", "Saw (2004)")
                    bundle.putFloat("score", 7.6f)
                    bundle.putString("brief", "Two strangers awaken in a room with no recollection of how they got there, and soon discover they're pawns in a deadly game perpetrated by a notorious serial killer.")
                }
                5L -> {
                    bundle.putString("name", "Breathe (2017)")
                    bundle.putFloat("score", 7.2f)
                    bundle.putString("brief", "The inspiring true love story of Robin (Andrew Garfield) and Diana Cavendish (Claire Foy), an adventurous couple who refuse to give up in the face of a devastating disease. Their heartwarming celebration of human possibility marks the directorial debut of Andy Serkis.")
                }
            }
            view.findNavController().navigate(R.id.action_shuffleFragment_to_todayMovieFragment, bundle)
//            Navigation.findNavController(view).navigate(R.id.action_shuffleFragment_to_todayMovieFragment)
        }
        return view
    }
}