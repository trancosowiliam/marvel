package br.com.dalcim.marvel.view.character

import br.com.dalcim.marvel.data.repository.remote.MarvelRepository

class CharactersPresenter(private val repository: MarvelRepository) : CharacterContract.Presenter {
    override lateinit var view: CharacterContract.View
}