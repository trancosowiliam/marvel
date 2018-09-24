package br.com.dalcim.marvel.data.repository.remote

import br.com.dalcim.marvel.data.model.CharacterMarvel
import br.com.dalcim.marvel.data.model.Comic

interface MarvelRepository {
    fun getCharacters(
            limit:Int,
            offset:Int,
            query:String?,
            onSuccess:(List<CharacterMarvel>) -> Unit,
            onFailure:(String) -> Unit)

    fun getComics(
            characterId:Long,
            onSuccess:(List<Comic>) -> Unit,
            onFailure:(String) -> Unit)
}