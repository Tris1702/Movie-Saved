package com.example.movie_save

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


class AddMovieFragment : Fragment() {
    lateinit var poster: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_movie, container, false)
        poster = view.findViewById<ImageView>(R.id.poster)
        poster.setOnClickListener{

/*
*
* Muon hieu thi cu bam vao ham roi dich ra se hieu =)) vang anh, the gio em co anh roi, em muon luu tru lai de sau con dung de hien thi tren 1 recyclerview, thi chuyen ve bitmap a?
* uhm dung roi anh tim bai viet cho
*
*
* @TypeConverter em dung cai nay de convert 1 object phuc tap thanh object co ban nhu dang string hay interger ... no nhu ma hoa ay em
* */
            // anh giai thich nhe /// e dung intent de gui qua vao app he thong
            // xong roi anh chon dc anh thi anh override cai ham onActitivy result thi chon dc cai anh
            // thi minh catch dc data theo duoi dang object Intent ///... hieu chua de em doc lai
            val intent = Intent()
            intent.type = "image/*" // cai nay kieu no phat lenh trong he thong nhu terminter cuar ubuntu ay
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)

//            lifecycleScope.launch(Dispatchers.IO){
//                val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
////                Log.d("check","check is enable ")
//                withContext(Dispatchers.Default){
//
//
//                }
//            }
        }
        val btn_update = view.findViewById<Button>(R.id.btn_update)
        btn_update.setOnClickListener{
            val txt_name = view.findViewById<EditText>(R.id.name_of_the_movie).text.toString()
            val score = view.findViewById<EditText>(R.id.score_of_the_movie).text.toString().toFloat()
            val txt_brief = view.findViewById<EditText>(R.id.brief_about_movie).text.toString()
            (activity as MainActivity).arrFinishedMovie.add(Movie(1, txt_name, score, txt_brief))
            (activity as MainActivity).movieAdapter1.notifyDataSetChanged()
            Toast.makeText(activity, "Your movie is saved", Toast.LENGTH_LONG).show()
            Navigation.findNavController(view).navigate(R.id.action_addMovieFragment_to_homeFragment)

        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1){
            poster.setImageURI(data?.data)
        }
    }
}