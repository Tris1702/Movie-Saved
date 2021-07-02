package com.example.movie_save

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class ListOfFinishedMovieFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_of_finished_movie, container, false)
        val act = (activity as MainActivity)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.findViewById<RecyclerView>(R.id.finished_movie_recycler_view)?.let{
            act.finishedMovieRecyclerView =it
            act.finishedMovieRecyclerView.layoutManager = linearLayoutManager
            act.movieAdapter1 = MovieAdapter(act.arrFinishedMovie)
            act.finishedMovieRecyclerView.adapter = act.movieAdapter1
        }
        return view
    }

}