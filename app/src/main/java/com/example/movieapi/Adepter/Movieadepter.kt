package com.example.movieapi.Adepter

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.movieapi.R
import com.example.movieapi.ResultsItem

class Movieadepter(results: List<ResultsItem?>?) : RecyclerView.Adapter<Movieadepter.Movieholder>() {
var results=results
    class Movieholder(itemView: View): ViewHolder(itemView) {
        var img=itemView.findViewById<ImageView>(R.id.imgMovie)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Movieholder {
        return Movieholder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false))
    }

    override fun getItemCount(): Int {
     return results?.size!!
    }

    override fun onBindViewHolder(holder: Movieholder, position: Int) {
 var str="https://image.tmdb.org/t/p/w500"
        Glide.with(holder.itemView.context).load(str+results?.get(position)?.posterPath).into(holder.img)

        holder.itemView.setOnClickListener {
            var dialog= Dialog(holder.itemView.context,com.google.android.material.R.style.Base_V14_Theme_Material3_Light_BottomSheetDialog)
            dialog.setContentView(R.layout.movie_dialog)
            var moviename= dialog.findViewById<TextView>(R.id.movieName)
            var language= dialog.findViewById<TextView>(R.id.lang)
            var realsedate= dialog.findViewById<TextView>(R.id.relaseDate)
            var desc= dialog.findViewById<TextView>(R.id.description)

            moviename.text=results?.get(position)?.originalTitle
            language.text=results?.get(position)?.originalLanguage
            desc.text=results?.get(position)?.overview

            dialog.show()

        }
    }
}