package com.gabrielmarrani.marvel.comics.repository

import com.gabrielmarrani.marvel.data.api.NetworkUtils
import com.gabrielmarrani.marvel.comics.model.ComicsModel
import com.gabrielmarrani.marvel.comics.model.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface IComicsEndpoint {
    @GET("v1/public/characters/1009610/comics")
    suspend fun getComics(@Query("offset") offset: Int? = 0): ResponseModel<ComicsModel>

    companion object {
        val Endpoint: IComicsEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(IComicsEndpoint::class.java)
        }
    }
}