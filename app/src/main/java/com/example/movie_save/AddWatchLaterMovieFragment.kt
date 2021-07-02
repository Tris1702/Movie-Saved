package com.example.movie_save

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.Navigation

class AddWatchLaterMovieFragment : Fragment() {
    lateinit var poster: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_watch_later_movie, container, false)
        poster = view.findViewById(R.id.poster_watch_later)
        poster.setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
        }
        val btn_add = view.findViewById<Button>(R.id.btn_add)
        val score = view.findViewById<EditText>(R.id.score_of_watch_later)
        btn_add.setOnClickListener{

            //Img -> Bitmap
            val imageView = view.findViewById<ImageView>(R.id.poster_watch_later)
            val bitmapImg = (imageView.drawable as BitmapDrawable).bitmap

            val txt_name = view.findViewById<EditText>(R.id.name_of_watch_later)?.text.toString()
            if (txt_name.isEmpty()) {
                val dialog = UnfIlledDialogFragment()
                dialog.show((activity as MainActivity).supportFragmentManager, "warning message")
                return@setOnClickListener
            }
            val txt_score = view.findViewById<EditText>(R.id.score_of_watch_later)?.text.toString()
            if (txt_score.isEmpty()){
                val dialog = UnfIlledDialogFragment()
                dialog.show((activity as MainActivity).supportFragmentManager, "warning message")
                return@setOnClickListener
            }
            var score = 0.0f
            if (txt_score.isNotEmpty()) score = txt_score.toFloat()
            val txt_brief = view.findViewById<EditText>(R.id.brief_watch_later)?.text.toString()
            if (txt_brief.isEmpty()){
                val dialog = UnfIlledDialogFragment()
                dialog.show((activity as MainActivity).supportFragmentManager, "warning message")
                return@setOnClickListener
            }
            (activity as MainActivity).arrWatchLaterMovie.add(Movie(bitmapImg, txt_name, score, txt_brief))
            (activity as MainActivity).movieAdapter2.notifyDataSetChanged()
            Toast.makeText(activity, "Your movie is added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(view).navigate(R.id.action_addWatchLaterMovieFragment_to_watchLaterFragment)
        }
        return view
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1){
            poster.setImageURI(data?.data)
        }
    }
}