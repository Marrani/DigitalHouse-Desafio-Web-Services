package com.gabrielmarrani.marvel.detalhe.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.gabrielmarrani.marvel.R
import com.squareup.picasso.Picasso

class ImagemDetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagem_detalhe)

        val thumbnail = intent.getStringExtra("COMICS_THUMBNAIL")
        Picasso.get()
            .load(thumbnail)
            .into(findViewById<ImageView>(R.id.imageFullscreen))

        val imgClose = findViewById<ImageView>(R.id.imgClose)
        imgClose.setOnClickListener {
            onBackPressed()
        }
    }
}