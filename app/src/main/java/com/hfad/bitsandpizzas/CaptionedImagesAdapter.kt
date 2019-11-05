package com.hfad.bitsandpizzas

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.text.FieldPosition

class CaptionedImagesAdapter(var captions:List<String>,var imageIds:List<Int>):
    RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CaptionedImagesAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.card_captioned_image,p0,false) as CardView)

    override fun getItemCount(): Int=captions.size

    override fun onBindViewHolder(p0: CaptionedImagesAdapter.ViewHolder, p1: Int) {
        p0.bind(p1)
    }
    inner class ViewHolder(var view:CardView): RecyclerView.ViewHolder(view) {
        fun bind (position:Int){
            val imageView=view.findViewById<ImageView>(R.id.info_image)
            val textView=view.findViewById<TextView>(R.id.info_text)
            val drawable =ContextCompat.getDrawable(view.context,imageIds[position])
            imageView.setImageDrawable(drawable)
            textView.setText(captions[position])

        }
    }

}

