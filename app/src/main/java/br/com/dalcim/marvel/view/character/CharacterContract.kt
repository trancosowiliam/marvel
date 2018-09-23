package br.com.dalcim.marvel.view.character

import br.com.dalcim.marvel.BasePresenter
import br.com.dalcim.marvel.BaseView
import br.com.dalcim.marvel.data.model.Comic

interface CharacterContract {
    interface Presenter : BasePresenter<View> {
        fun loadComics(characterId: Long)
    }

    interface View : BaseView<Presenter> {
        fun loadingList(isLoading: Boolean)
        fun addItens(comics: List<Comic>)
        fun showMessage(message: String)
    }
}