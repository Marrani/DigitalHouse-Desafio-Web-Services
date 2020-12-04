package com.gabrielmarrani.marvel.comics.repository

class ComicsRepository {

    private val client = IComicsEndpoint.Endpoint

    suspend fun getComics(offset: Int? = 0) = client.getComics(offset)
}