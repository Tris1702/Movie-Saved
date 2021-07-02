package com.example.movie_save

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private var dataMovie: ArrayList<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false) as View
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageBitmap(dataMovie[position].bitmapImg)
        holder.name.text = dataMovie[position].name
        holder.brief.text = dataMovie[position].brief
        holder.score.text = dataMovie[position].score.toString() + "/5.0"
    }

    override fun getItemCount(): Int {
        return dataMovie.size
    }

    fun removeItem(position: Int) {
        dataMovie.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name_item)
        var imageView: ImageView = itemView.findViewById(R.id.poster)
        var brief: TextView = itemView.findViewById(R.id.brief_item)
        var score: TextView = itemView.findViewById(R.id.score_item)

        init {
            itemView.setOnClickListener{
                Log.e("Tris", "this")
                confirmdelete(it, position)
            }
        }

        private fun confirmdelete(itemView: View, position: Int) {
            val popUpMenu = PopupMenu(itemView.context, itemView)
            popUpMenu.inflate(R.menu.layout_pop_up_menu)
            popUpMenu.show()
            popUpMenu.setOnMenuItemClickListener {
                if (it.itemId == R.id.delete_option) removeItem(position)
                true
            }
        }
    }
}