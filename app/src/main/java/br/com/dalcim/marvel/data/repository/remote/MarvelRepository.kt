package br.com.dalcim.marvel.data.repository.remote

import br.com.dalcim.marvel.data.model.CharacterMarvel

interface MarvelRepository {
    fun getCharacters(
            limit:Int,
            offset:Int,
            query:String?,
            onSuccess:(List<CharacterMarvel>) -> Unit,
            onFailure:(String) -> Unit)
}