package br.com.dalcim.marvel.view.characters

import br.com.dalcim.marvel.data.repository.remote.MarvelRepository

private const val LIMIT_CHARACTER = 100

class CharactersPresenter(private val repository: MarvelRepository) : CharactersContract.Presenter {
    override lateinit var view: CharactersContract.View

    override fun loadCharacters(offset: Int, query: String?) {
        view.loadingList(true)

        repository.getCharacters(LIMIT_CHARACTER, offset, query, onSuccess = { characters ->
            view.loadingList(false)
            view.addItens(characters)
        }, onFailure = { message ->
            view.loadingList(false)
            view.showMessage(message)
        })
    }


}