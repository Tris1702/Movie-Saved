package com.example.movie_save

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val btn_show_list = view.findViewById<Button>(R.id.btn_show_list)

        btn_show_list.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_listOfFinishedMovieFragment)
        }

        val btn_add = view.findViewById<Button>(R.id.btn_add)
        btn_add.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_addMovieFragment)
        }
        val btn_discover = view.findViewById<Button>(R.id.btn_discover)
        btn_discover.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_shuffleFragment)
        }
        val number_of_finished_movie = view.findViewById<TextView>(R.id.number_of_finished_movie)
        number_of_finished_movie.text = (activity as MainActivity).arrFinishedMovie.size.toString()
        return view
    }

}