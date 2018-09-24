package br.com.dalcim.marvel.view.characters

import br.com.dalcim.marvel.BasePresenter
import br.com.dalcim.marvel.BaseView
import br.com.dalcim.marvel.data.model.CharacterMarvel

interface CharactersContract{
    interface Presenter : BasePresenter<View> {
        fun loadCharacters(offset: Int, query: String?)
    }

    interface View : BaseView<Presenter> {
        fun loadingList(isLoading: Boolean)
        fun addItens(characters: List<CharacterMarvel>)
        fun showMessage(message: String)
    }
}