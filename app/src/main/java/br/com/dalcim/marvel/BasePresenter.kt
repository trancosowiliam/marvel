package br.com.dalcim.marvel

interface BasePresenter<T> {
    var view:T

    operator fun invoke(view: T) {
        this.view = view
    }
}