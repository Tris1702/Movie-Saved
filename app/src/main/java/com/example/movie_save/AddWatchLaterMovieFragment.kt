package com.example.movie_save

import android.content.Intent
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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddWatchLaterMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddWatchLaterMovieFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_add_watch_later_movie, container, false)
        val poster = view.findViewById<ImageView>(R.id.poster_watch_later)
        poster.setOnClickListener{
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            poster.setImageURI(gallery.data)
        }
        val btn_update = view.findViewById<Button>(R.id.btn_add)
        btn_update.setOnClickListener{
            val txt_name = view.findViewById<EditText>(R.id.name_of_watch_later).text.toString()
            val score = view.findViewById<EditText>(R.id.score_of_watch_later).text.toString().toFloat()
            val txt_brief = view.findViewById<EditText>(R.id.brief_watch_later).text.toString()
            (activity as MainActivity).arrWatchLaterMovie.add(Movie(1, txt_name, score, txt_brief))
            Toast.makeText(activity, "Your movie is added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(view).navigate(R.id.action_addWatchLaterMovieFragment_to_watchLaterFragment)
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddWatchLaterMovieFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddWatchLaterMovieFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}