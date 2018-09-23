package br.com.dalcim.marvel.module

import br.com.dalcim.marvel.data.repository.remote.MarvelRepository
import br.com.dalcim.marvel.data.repository.remote.MarvelRepositoryImpl
import br.com.dalcim.marvel.view.characters.CharactersContract
import br.com.dalcim.marvel.view.characters.CharactersPresenter
import org.koin.dsl.module.applicationContext

val applicationModule = applicationContext {
    factory { CharactersPresenter(get()) as CharactersContract.Presenter }

    factory { MarvelRepositoryImpl(retrofit = get()) as MarvelRepository }
}