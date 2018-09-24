package br.com.dalcim.marvel.view.character

import br.com.dalcim.marvel.data.repository.remote.MarvelRepository

class CharacterPresenter(private val repository: MarvelRepository) : CharacterContract.Presenter {
    override lateinit var view: CharacterContract.View

    override fun loadComics(characterId: Long) {
        view.loadingList(true)

        repository.getComics(characterId, onSuccess = { comics ->
            view.loadingList(false)
            view.addItens(comics)
        }, onFailure = { message ->
            view.loadingList(false)
            view.showMessage(message)
        })
    }
}
