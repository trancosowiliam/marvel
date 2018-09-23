package br.com.dalcim.marvel.view.character

import br.com.dalcim.marvel.BasePresenter
import br.com.dalcim.marvel.BaseView

interface CharacterContract {
    interface Presenter : BasePresenter<View> {

    }

    interface View : BaseView<Presenter> {

    }
}