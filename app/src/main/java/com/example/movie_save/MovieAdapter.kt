package com.example.movie_save

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private var dataMovie: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false) as View
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = dataMovie[position].name
        holder.brief.text = dataMovie[position].brief
        holder.score.text = dataMovie[position].score.toString()
    }

    override fun getItemCount(): Int {
        return dataMovie.size
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name: TextView = itemView.findViewById(R.id.name_item)
        var poster = 0
        var brief: TextView = itemView.findViewById(R.id.brief_item)
        var score: TextView = itemView.findViewById(R.id.score_item)
    }
}