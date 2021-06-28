package com.example.movie_save

import android.os.Bundle
import android.os.RecoverySystem
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WatchLaterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_watch_later, container, false)
        val btn_add = view.findViewById<Button>(R.id.btn_add_watch_later)

        val act = (activity as MainActivity)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.findViewById<RecyclerView> (R.id.watch_later_recycler_view)?.let {
            Log.e("tris","this")
            act.watchLaterRecyclerView =it
            act.watchLaterRecyclerView.layoutManager = linearLayoutManager
            act.watchLaterRecyclerView.hasFixedSize()
            act.movieAdapter2 = MovieAdapter(act.arrWatchLaterMovie)
            act.watchLaterRecyclerView.adapter = act.movieAdapter2
        }
        btn_add.setOnClickListener{
            (activity as MainActivity).movieAdapter2.notifyDataSetChanged()
            Navigation.findNavController(view).navigate(R.id.action_watchLaterFragment_to_addWatchLaterMovieFragment)
        }
        return view
    }

}