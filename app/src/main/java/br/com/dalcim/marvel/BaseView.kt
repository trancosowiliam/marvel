package br.com.dalcim.marvel

interface BaseView<out T : BasePresenter<*>> {
    val presenter: T
}