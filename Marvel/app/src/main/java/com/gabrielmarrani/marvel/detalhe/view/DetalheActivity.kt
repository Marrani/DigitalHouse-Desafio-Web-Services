package com.gabrielmarrani.marvel.detalhe.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.gabrielmarrani.marvel.R
import com.gabrielmarrani.marvel.comics.repository.ComicsRepository
import com.gabrielmarrani.marvel.comics.viewmodel.ComicsViewModel
import com.squareup.picasso.Picasso

class DetalheActivity : AppCompatActivity() {
    private lateinit var _viewModel: ComicsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val thumbnail = getDadosComics()
        goImageFull(thumbnail)
        viewModelProvider()
        val goBackHome = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarDetalhes)
        goBackHome.setOnClickListener {
            onBackPressed()
        }
    }

    private fun goImageFull(thumbnail: String?) {
        val imgThumbnail = findViewById<ImageView>(R.id.imgMiniDetalhe)
        imgThumbnail.setOnClickListener {
            val intent = Intent(this@DetalheActivity, ImagemDetalheActivity::class.java)
            intent.putExtra("COMICS_THUMBNAIL", thumbnail)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getDadosComics(): String? {
        val id = intent.getStringExtra("COMICS_ID")
        val titulo = intent.getStringExtra("COMICS_TITLE")
        val descricao = intent.getStringExtra("COMICS_DESCRIPTION")
        val paginas = intent.getIntExtra("COMICS_PAGES", 0)
        val dataPublicacao = intent.getStringExtra("COMICS_DATE")
        val preco = intent.getFloatExtra("COMICS_PRECO", 0f)
        val thumbnail = intent.getStringExtra("COMICS_THUMBNAIL")


        findViewById<TextView>(R.id.txtTitleDetalhes).text = titulo
        findViewById<TextView>(R.id.txtDataPublicacao).text = dataPublicacao
        val txtDescription = findViewById<TextView>(R.id.txtDescription)
        findViewById<TextView>(R.id.txtPagesValue).text = paginas.toString()
        findViewById<TextView>(R.id.txtPriceValue).text = "$ ${preco.toString()}"


        if (descricao != null) {
            txtDescription.text = descricao
        }

        Picasso.get().load(thumbnail).into(findViewById<ImageView>(R.id.imgMiniDetalhe))

        Picasso.get()
            .load(thumbnail)
            .into(findViewById<ImageView>(R.id.imgDetalhe))


        return thumbnail
    }

    private fun viewModelProvider() {
        _viewModel = ViewModelProvider(
            this,
            ComicsViewModel.ComicViewModelFactory(ComicsRepository())
        ).get(ComicsViewModel::class.java)
    }
}