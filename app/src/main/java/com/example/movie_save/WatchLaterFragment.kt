package com.example.movie_save

import android.os.Bundle
import android.os.RecoverySystem
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WatchLaterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WatchLaterFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_watch_later, container, false)
        val btn_add = view.findViewById<Button>(R.id.btn_add_watch_later)

        val act = (activity as MainActivity)
        act.findViewById<RecyclerView> (R.id.watch_later_recycler_view)?.let {
            act.watchLaterRecyclerView =it
            act.watchLaterRecyclerView.hasFixedSize()
            act.movieAdapter2 = MovieAdapter(act.arrWatchLaterMovie)
            act.watchLaterRecyclerView.adapter = act.movieAdapter2
        }
        btn_add.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_watchLaterFragment_to_addWatchLaterMovieFragment)
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
         * @return A new instance of fragment WatchLaterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WatchLaterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}