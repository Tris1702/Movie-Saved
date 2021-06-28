package com.example.movie_save

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class TodayMovieFragment : Fragment() {
    lateinit var txtNameOfTodayMovie: TextView
    lateinit var txtBrief: TextView
    lateinit var score : TextView
    lateinit var poster: ImageView
    var idImg = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_today_movie, container, false)
        txtNameOfTodayMovie = view.findViewById(R.id.name_of_today_film)
        txtBrief = view.findViewById(R.id.brief)
        poster = view.findViewById(R.id.poster)
        score = view.findViewById(R.id.score)

        txtNameOfTodayMovie.text = arguments?.getString("name")
        txtBrief.text = arguments?.getString("brief")
        score.text = arguments?.getFloat("score").toString()
        idImg = arguments?.getLong("idImg")!!

        poster.setImageResource(resources.getIdentifier("ran"+idImg.toString(), "drawable", "com.example.movie_save"))
        return view
    }
}