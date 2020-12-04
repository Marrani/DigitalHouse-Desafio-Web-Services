package com.gabrielmarrani.marvel.comics.model

import com.google.gson.annotations.SerializedName

data class PrecosModel(
    @SerializedName("type")
    val tipo: String?,
    @SerializedName("price")
    val preco: Float?
)