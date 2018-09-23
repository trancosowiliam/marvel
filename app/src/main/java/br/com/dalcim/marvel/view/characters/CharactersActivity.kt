package br.com.dalcim.marvel.view.characters

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.dalcim.marvel.R
import org.koin.android.ext.android.inject

class CharactersActivity : AppCompatActivity(), CharactersContract.View {
    override val presenter by inject<CharactersContract.Presenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)
        presenter.view = this
    }
}
