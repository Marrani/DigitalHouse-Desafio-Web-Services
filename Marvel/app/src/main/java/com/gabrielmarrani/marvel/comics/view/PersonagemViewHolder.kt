package com.example.marvelhq.home.view.adapter

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gabrielmarrani.marvel.R
import com.gabrielmarrani.marvel.comics.model.ComicsModel
import com.squareup.picasso.Picasso

class PersonagemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val imagem = view.findViewById<ImageView>(R.id.imgPersonagem)
    private val idPersonagem = view.findViewById<TextView>(R.id.txtPersonagem)

    @SuppressLint("SetTextI18n")
    fun bind(personagemModel: ComicsModel) {
        idPersonagem.text = " # ${personagemModel.id}"
        val imagePath = personagemModel.thumbnail?.getImagePath()
        Picasso.get().load(imagePath).into(imagem)
    }
}