package br.com.dalcim.marvel.view.characters

import br.com.dalcim.marvel.BasePresenter
import br.com.dalcim.marvel.BaseView
import br.com.dalcim.marvel.data.model.CharacterMarvel

interface CharactersContract{
    interface Presenter : BasePresenter<View> {

    }

    interface View : BaseView<Presenter> {

    }
}